package com.ceiba.vigilante.service;

import com.ceiba.vigilante.dominio.Ingreso;

public interface VigilanteService {

	void registrarVehiculoAIngresar(Ingreso ingreso);
	public double cobrar(Ingreso ingreso); 
	

}
