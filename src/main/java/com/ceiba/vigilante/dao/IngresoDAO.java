package com.ceiba.vigilante.dao;

import java.util.List;

import com.ceiba.vigilante.dominio.Ingreso;
import com.ceiba.vigilante.dominio.Vehiculo;
import com.ceiba.vigilante.entity.IngresoEntity;

public interface IngresoDAO {

	void agregarIngreso(Ingreso ingreso);
	
	public List<IngresoEntity> obtenerIngresosTotales();

	public Vehiculo obtenerIngresoPorPlaca(String placa);
	
	public int obtenerIngresosPorTipoVehiculoParqueado(String tipoVehiculo);

	
}
