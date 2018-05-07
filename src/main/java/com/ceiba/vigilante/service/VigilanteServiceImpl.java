package com.ceiba.vigilante.service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.ceiba.vigilante.constantes.MensajeException;
import com.ceiba.vigilante.constantes.Tarifa;
import com.ceiba.vigilante.dao.IngresoDAO;
import com.ceiba.vigilante.dominio.Ingreso;
import com.ceiba.vigilante.dominio.Parqueadero;
import com.ceiba.vigilante.dominio.Vehiculo;
import com.ceiba.vigilante.excepcion.IngresoException;

public class VigilanteServiceImpl implements VigilanteService {

	// AQUI HAGO LA INYECCION DE DEPENDENCIAS
	private IngresoDAO ingresoDAO;

	@Override
	public void registrarVehiculoAIngresar(Ingreso ingreso) {

		if (ingreso.getVehiculo() == null) {
			throw new IngresoException(MensajeException.INGRESO_SIN_VEHICULO);
		}
		if ((!(validarCuposPorTipo(ingreso.getVehiculo())))) {
			throw new IngresoException(MensajeException.INGRESO_SIN_CUPOS);
		}

		if (!(validarPlaca(ingreso) && validarDiaIngreso())) {
			throw new IngresoException(MensajeException.INGRESO_NO_AUTORIZADO);
		}

		ingresoDAO.agregarIngreso(ingreso);

	}

	@Override
	public double cobrar(Ingreso ingreso) {
		if (ingreso != null) {

			if (ingreso.getVehiculo().getTipoVehiculo() == Vehiculo.VEHICULO_TIPO_MOTO) {
				calcularPagoMoto(ingreso.getVehiculo(), ingreso.getHoraIngreso());
			}
			if (ingreso.getVehiculo().getTipoVehiculo() == Vehiculo.VEHICULO_TIPO_CARRO) {
				calcularPagoCarro(ingreso.getVehiculo(), ingreso.getHoraIngreso());
			}

		}
		return 0;
	}

	private boolean validarCuposPorTipo(Vehiculo vehiculo) {
		if (vehiculo.getTipoVehiculo() == Vehiculo.VEHICULO_TIPO_CARRO) {
			return validarCuposCarros(vehiculo);
		} else {
			return validarCuposMotos(vehiculo);
		}
	}

	private boolean validarCuposCarros(Vehiculo vehiculo) {
		boolean cuposDisponibles = false;
		if (ingresoDAO.obtenerIngresosPorTipoVehiculoParqueado(
				vehiculo.getTipoVehiculo()) < Parqueadero.CUPOS_TOTALES_CARROS) {
			cuposDisponibles = true;
		}
		return cuposDisponibles;
	}

	private boolean validarCuposMotos(Vehiculo vehiculo) {
		boolean cuposDisponibles = false;
		if (ingresoDAO.obtenerIngresosPorTipoVehiculoParqueado(
				vehiculo.getTipoVehiculo()) < Parqueadero.CUPOS_TOTALES_MOTOS) {
			cuposDisponibles = true;
		}
		return cuposDisponibles;
	}

	public boolean validarPlaca(Ingreso ingreso) {
		return ingreso.getVehiculo().getPlaca().charAt(0) == 'A';
	}

	public boolean validarDiaIngreso() {
		DayOfWeek dia = LocalDateTime.now().getDayOfWeek();
		return dia.equals(DayOfWeek.SUNDAY) || dia.equals(DayOfWeek.MONDAY);
	}

	private double calcularPagoMoto(Vehiculo vehiculo, LocalDateTime horaIngreso) {
		double totalPagar = 0;
		LocalDateTime horaFinal = LocalDateTime.now();
		int horasParqueado = (int) ChronoUnit.HOURS.between(horaFinal, horaIngreso);
		if (horasParqueado >= 9) {
			if (horasParqueado < 25) {
				totalPagar = Tarifa.TARIFA_DIA_MOTO;
			} else {
				int resultadoDias = Math.round(horasParqueado / 24);

				int resultadoHoras = horasParqueado - resultadoDias * 24;
				totalPagar = resultadoDias * Tarifa.TARIFA_DIA_MOTO + (resultadoHoras * Tarifa.TARIFA_HORA_MOTO);
				totalPagar = vehiculo.getCilindraje() > 500 ? aumentoPorCilindraje(totalPagar) : totalPagar;

			}
		} else {
			totalPagar = horasParqueado * Tarifa.TARIFA_HORA_MOTO;
			totalPagar = vehiculo.getCilindraje() > 500 ? aumentoPorCilindraje(totalPagar) : totalPagar;

		}

		return totalPagar;
	}

	private double aumentoPorCilindraje(double totalPagar) {
		return totalPagar + 2000;
	}

	private double calcularPagoCarro(Vehiculo vehiculo, LocalDateTime horaIngreso) {
		double totalPagar = 0;
		LocalDateTime horaFinal = LocalDateTime.now();
		int horasParqueado = (int) ChronoUnit.HOURS.between(horaFinal, horaIngreso);
		if (horasParqueado >= 9) {
			if (horasParqueado < 25) {
				totalPagar = Tarifa.TARIFA_DIA_CARRO;
			} else {
				int resultadoDias = Math.round(horasParqueado / 24);

				int resultadoHoras = horasParqueado - (resultadoDias * 24);
				totalPagar = ((resultadoDias * Tarifa.TARIFA_DIA_CARRO) + (resultadoHoras * Tarifa.TARIFA_HORA_CARRO));
			}
		} else {
			totalPagar = (horasParqueado * Tarifa.TARIFA_HORA_CARRO);
		}
		return totalPagar;
	}

}
