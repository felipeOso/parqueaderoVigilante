package com.ceiba.vigilante.persistencia.jpa;

import java.util.List;

import com.ceiba.vigilante.entity.VehiculoEntity;

public interface VehiculoPersistenteJpa {

	 List<VehiculoEntity> obtenerVehiculoEntityTotales();
}
