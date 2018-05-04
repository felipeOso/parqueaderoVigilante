package com.ceiba.vigilante.persistencia.jpa;

import com.ceiba.vigilante.entity.VehiculoEntity;

public interface IngresoPersistenteJpa {
	
	VehiculoEntity obtenerVehiculoEntityByPlaca(String Placa);
}
