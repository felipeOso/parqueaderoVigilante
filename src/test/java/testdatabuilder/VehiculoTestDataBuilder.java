package testdatabuilder;

import com.ceiba.vigilante.dominio.Vehiculo;

/* TENEMOS EN CUENTA EL PATRON DATABUILDER*/

public class VehiculoTestDataBuilder {

	private static final  String PLACA="abc123";
	private static final String TIPO_VEHICULO ="Moto";
	
	private String placa;
	private String tipoVehiculo;
	
	public VehiculoTestDataBuilder() {
		this.placa =PLACA;
		this.tipoVehiculo= TIPO_VEHICULO;
	}
	
	public VehiculoTestDataBuilder conPlaca(String placa) {
		this.placa= placa;
		return this;
	}
	
	public VehiculoTestDataBuilder conTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo= tipoVehiculo;
		return this;
	}
	public Vehiculo build() {
		return new Vehiculo(this.placa, this.tipoVehiculo) {
		};
	}
}
