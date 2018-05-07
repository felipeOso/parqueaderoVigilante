package com.ceiba.vigilante.dominio;

public class Vehiculo {

	private String placa;
	private String tipoVehiculo;
	private double cilindraje;
	

	public static final String VEHICULO_TIPO_MOTO = "Moto";
	public static final String VEHICULO_TIPO_CARRO = "Carro";

	public Vehiculo(String placa, String tipoVehiculo, double cilindraje) {
		super();
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.cilindraje = cilindraje;
	}
	public Vehiculo(String placa, String tipoVehiculo) {
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

	public double getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(double cilindraje) {
		this.cilindraje = cilindraje;
	}
}
