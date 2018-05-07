package com.ceiba.vigilante.controllers;

import com.ceiba.vigilante.dominio.Ingreso;
import com.ceiba.vigilante.service.VigilanteService;

public class VigilanteController {

	private VigilanteService vigilanteService;

	// AQUI LE PASO LOS VALORES DEL FRONTEND, la firma de Ingreso(vehiculo, horaIngreso, totalPagar, horaSalida)
	Ingreso ingreso = new Ingreso();

	public VigilanteController(VigilanteService vigilanteService) {
		super();
		this.vigilanteService = vigilanteService;
	}

	public void registrarVehiculo(Ingreso ingreso) {
		vigilanteService.registrarVehiculoAIngresar(ingreso);
	}

	public double cobrar(Ingreso ingreso) {
		return vigilanteService.cobrar(ingreso);
	}
}
