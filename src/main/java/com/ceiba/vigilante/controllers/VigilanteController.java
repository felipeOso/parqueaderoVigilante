package com.ceiba.vigilante.controllers;

import com.ceiba.vigilante.dao.IngresoDAO;
import com.ceiba.vigilante.dao.VehiculoDAO;
import com.ceiba.vigilante.dominio.Ingreso;
import com.ceiba.vigilante.dominio.Vehiculo;
import com.ceiba.vigilante.service.IngresoService;
import com.ceiba.vigilante.service.VehiculoService;

public class VigilanteController {

	private IngresoService ingresoService;
	private VehiculoService vehiculoService;

	// AQUI LE PASO LOS VALORES DEL FRONTEND
		Ingreso ingreso = new Ingreso();
		


	public VigilanteController(IngresoService ingresoService, VehiculoService vehiculoService) {
		super();
		this.ingresoService = ingresoService;
		this.vehiculoService = vehiculoService;
	}

	public void ingresarVehiculo(Vehiculo vehiculo) {
		 ingresoService.agregarIngreso(ingreso);
	}

	public double cobrar(IngresoDAO ingresoDAO, VehiculoDAO vehiculoDAO) {
		return ingresoService.cobrar(ingreso);
	}
}
