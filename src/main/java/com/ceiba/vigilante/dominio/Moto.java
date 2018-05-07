package com.ceiba.vigilante.dominio;

public class Moto extends Vehiculo {

	public Moto(String placa, String tipoVehiculo, double cilindraje) {
		super(placa, tipoVehiculo, cilindraje);
		this.setTipoVehiculo("Moto");
	}

}
