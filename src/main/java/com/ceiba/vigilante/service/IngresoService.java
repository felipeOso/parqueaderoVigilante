package com.ceiba.vigilante.service;

import com.ceiba.vigilante.dominio.Ingreso;

public interface IngresoService {

	void agregarIngreso(Ingreso ingreso);
	public double cobrar(Ingreso ingreso); 
	

}
