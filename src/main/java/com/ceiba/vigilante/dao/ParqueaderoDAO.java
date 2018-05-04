package com.ceiba.vigilante.dao;

import com.ceiba.vigilante.dominio.Parqueadero;

public interface ParqueaderoDAO {

	//public int cuposDisponiblesParqueadero(Parqueadero parqueadero);
	
	public int cuposDisponiblesMotos(Parqueadero parqueadero);
	public int cuposDisponiblesCarros(Parqueadero parqueadero);
	
	
}
