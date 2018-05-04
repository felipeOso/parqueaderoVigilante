package com.ceiba.vigilante.dao;

import com.ceiba.vigilante.dominio.Parqueadero;

public class ParqueaderoDAOImpl implements ParqueaderoDAO {

	public static final int CUPOS_TOTALES_MOTOS = 10;
	public static final int CUPOS_TOTALES_CARROS = 20;

	@Override
	public int cuposDisponiblesMotos(Parqueadero parqueadero) {
		if (parqueadero.getCuposTotalesMotos() < CUPOS_TOTALES_MOTOS) {
			int cuposDisponiblesMotos = parqueadero.getCuposTotalesMotos() - CUPOS_TOTALES_MOTOS;
			return cuposDisponiblesMotos;
		}
		return 0;
	}

	@Override
	public int cuposDisponiblesCarros(Parqueadero parqueadero) {
		if (parqueadero.getCuposTotalesCarros() < CUPOS_TOTALES_CARROS) {
			int cuposDisponiblesCarros = parqueadero.getCuposTotalesCarros() - CUPOS_TOTALES_CARROS;
			return cuposDisponiblesCarros;
		}
		return 0;
	}

}
