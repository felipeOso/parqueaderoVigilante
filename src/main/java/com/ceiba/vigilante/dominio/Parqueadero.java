package com.ceiba.vigilante.dominio;

public class Parqueadero {

	private int cuposTotalesMotos;
	private int cuposTotalesCarros;
	
	public static final Integer CUPOS_TOTALES_MOTOS = 10;
	public static final Integer CUPOS_TOTALES_CARROS = 20;
	public Parqueadero() {
		super();
		this.cuposTotalesMotos = CUPOS_TOTALES_MOTOS;
		this.cuposTotalesCarros = CUPOS_TOTALES_CARROS;
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
