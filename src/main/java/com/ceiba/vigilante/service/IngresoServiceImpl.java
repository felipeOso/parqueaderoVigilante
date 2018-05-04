package com.ceiba.vigilante.service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.ceiba.vigilante.dao.IngresoDAO;
import com.ceiba.vigilante.dominio.Ingreso;
import com.ceiba.vigilante.dominio.Vehiculo;
import com.ceiba.vigilante.excepcion.IngresoException;
import com.ceiba.vigilante.excepcion.VehiculoException;

public class IngresoServiceImpl implements IngresoService {

	// AQUI HAGO LA INYECCION DE DEPENDENCIAS
	private IngresoDAO ingresoDAO;

	public static final String INGRESO_SIN_VEHICULO = "No se tiene un vehiculo para ingresar, por favor ingrese un vehiculo";
	public static final String INGRESO_NO_AUTORIZADO = "Las placas que empiezan por A solo pueden ingresar los lunes y domingos";

	public static final String VEHICULO_TIPO_MOTO = "Moto";
	public static final String VEHICULO_TIPO_CARRO = "Carro";

	public static final int VALOR_DIA_CARRO = 8000;
	public static final int VALOR_HORA_CARRO = 1000;
	public static final int VALOR_DIA_MOTO = 4000;
	public static final int VALOR_HORA_MOTO = 500;

	@Override
	public void agregarIngreso(Ingreso ingreso) {
		
		
		if( ingreso.getVehiculo() == null ) {
			throw new VehiculoException(INGRESO_SIN_VEHICULO);
		}
		
		if( !(validarPlaca(ingreso) && validarDiaIngreso()) ) {
			throw new IngresoException(INGRESO_NO_AUTORIZADO);
		}
		

		ingresoDAO.agregarIngreso(ingreso);
		

	}

	private boolean validarPlaca(Ingreso ingreso) {
		return ingreso.getVehiculo().getPlaca().charAt(0) == 'A';
	}

	@Override
	public double cobrar(Ingreso ingreso) {
		if (ingreso != null) {

			if (ingreso.getVehiculo().getTipoVehiculo() == VEHICULO_TIPO_MOTO) {
				calcularPagoMoto(ingreso.getVehiculo(), ingreso.getHoraIngreso());
			}
			if (ingreso.getVehiculo().getTipoVehiculo() == VEHICULO_TIPO_CARRO) {
				calcularPagoCarro(ingreso.getVehiculo(), ingreso.getHoraIngreso());
			}

		}
		return 0;
	}

	private double calcularPagoMoto(Vehiculo vehiculo, LocalDateTime horaIngreso) {
		double totalPagar=0;
		LocalDateTime horaFinal = LocalDateTime.now();
		int horasParqueado = (int) ChronoUnit.HOURS.between(horaFinal, horaIngreso);
		if (horasParqueado >= 9) {
			if (horasParqueado < 25) {
				totalPagar = VALOR_DIA_MOTO;
			} else {
				int resultadoDias = Math.round(horasParqueado / 24);

				int resultadoHoras = horasParqueado - resultadoDias * 24;
				totalPagar = resultadoDias * VALOR_DIA_MOTO + (resultadoHoras * VALOR_HORA_MOTO);
			}
		}else {
			totalPagar=horasParqueado * VALOR_HORA_MOTO;
		}
		
		return totalPagar;
	}

	
	private double calcularPagoCarro(Vehiculo vehiculo, LocalDateTime horaIngreso) {
		double totalPagar = 0;
		LocalDateTime horaFinal = LocalDateTime.now();
		int horasParqueado = (int) ChronoUnit.HOURS.between(horaFinal, horaIngreso);
		if (horasParqueado >= 9) {
			if (horasParqueado < 25) {
				totalPagar = VALOR_DIA_CARRO;
			} else {
				int resultadoDias = Math.round(horasParqueado / 24);

				int resultadoHoras = horasParqueado - resultadoDias * 24;
				totalPagar = resultadoDias * VALOR_DIA_CARRO + (resultadoHoras * VALOR_HORA_CARRO);
			}
		}else {
			totalPagar=horasParqueado * VALOR_HORA_CARRO;
		}
		return totalPagar;
	}
	
	public boolean validarDiaIngreso() {
		DayOfWeek dia = LocalDateTime.now().getDayOfWeek();
		return dia.equals(dia.SUNDAY) || dia.equals(dia.MONDAY);
	}

}
