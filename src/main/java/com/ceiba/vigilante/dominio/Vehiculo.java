package com.ceiba.vigilante.dominio;

public  class Vehiculo {

	private String placa;
	private String tipoVehiculo;

	public  Vehiculo(String placa, String tipoVehiculo) {
		super();
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
}
