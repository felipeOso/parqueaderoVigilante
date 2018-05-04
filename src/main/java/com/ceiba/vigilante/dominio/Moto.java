package com.ceiba.vigilante.dominio;

public class Moto extends Vehiculo{

	private String cilindraje;

	public Moto(String placa, String tipoVehiculo, String cilindraje) {
		super(placa, tipoVehiculo);
		this.cilindraje = cilindraje;
		this.setTipoVehiculo("Moto");
	}

	public String getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}
}
