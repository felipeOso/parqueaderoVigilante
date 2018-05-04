package testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.vigilante.dominio.Ingreso;
import com.ceiba.vigilante.dominio.Vehiculo;

public class IngresoTestDataBuilder {

	private Vehiculo vehiculo;
	private double totalPagar;
	private LocalDateTime horaIngreso;
	private LocalDateTime horaSalida;

	public static final LocalDateTime HORA_INGRESO = LocalDateTime.now();
	public static final String TIPO_VEHICULO = "Moto";

	public IngresoTestDataBuilder(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
		this.horaIngreso = LocalDateTime.now();
		this.horaSalida = null;
		this.totalPagar = 0;
	}

	public IngresoTestDataBuilder conVehiculo(Vehiculo vehiculo) {
		this.vehiculo.setTipoVehiculo(TIPO_VEHICULO);
		return this;
	}
	
	public IngresoTestDataBuilder conHoraIngreso(LocalDateTime horaIngreso) {
		this.horaIngreso = horaIngreso;
		return this;
	}
	
	public IngresoTestDataBuilder conHoraSalida(LocalDateTime horaSalida) {
		this.horaSalida= horaSalida;
		return this;
	}
	public IngresoTestDataBuilder conTotalPagar(double totalPagar) {
		this.totalPagar= totalPagar;
		return this;
	}
	
	public Ingreso build() {
		return new Ingreso(this.vehiculo, this.horaIngreso, this.totalPagar, this.horaSalida);
	}
}
