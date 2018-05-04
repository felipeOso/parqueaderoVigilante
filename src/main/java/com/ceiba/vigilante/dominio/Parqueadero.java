package com.ceiba.vigilante.dominio;

public class Parqueadero {

	private int cuposTotalesMotos;
	private int cuposTotalesCarros;

	public Parqueadero() {
		super();
		this.cuposTotalesMotos = 10;
		this.cuposTotalesCarros = 20;
	}

	public Parqueadero(int cuposTotalesMotos, int cuposTotalesCarros) {
		super();
		this.cuposTotalesMotos = cuposTotalesMotos;
		this.cuposTotalesCarros = cuposTotalesCarros;
	}

	public int getCuposTotalesMotos() {
		return cuposTotalesMotos;
	}

	public void setCuposTotalesMotos(int cuposTotalesMotos) {
		this.cuposTotalesMotos = cuposTotalesMotos;
	}

	public int getCuposTotalesCarros() {
		return cuposTotalesCarros;
	}

	public void setCuposTotalesCarros(int cuposTotalesCarros) {
		this.cuposTotalesCarros = cuposTotalesCarros;
	}
}
