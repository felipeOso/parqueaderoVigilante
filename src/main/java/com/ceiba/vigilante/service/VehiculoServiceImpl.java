package com.ceiba.vigilante.service;

import com.ceiba.vigilante.dao.VehiculoDAO;
import com.ceiba.vigilante.dominio.Vehiculo;

public class VehiculoServiceImpl implements VehiculoService {

	private VehiculoDAO vehiculoDAO;
	@Override
	public void agregarVehiculo(Vehiculo vehiculo) {
		
		vehiculoDAO.agregarVehiculo(vehiculo);
	}

}
