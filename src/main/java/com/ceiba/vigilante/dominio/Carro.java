package com.ceiba.vigilante.dominio;

public class Carro extends Vehiculo{

	public Carro(String placa, String tipoVehiculo) {
		super(placa,tipoVehiculo);
		this.setTipoVehiculo("Carro");
	}
}
