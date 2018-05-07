package com.ceiba.vigilante.factoria;

import com.ceiba.vigilante.dominio.Vehiculo;

public interface VehiculoFactory {
	public Vehiculo crearTipoVehiculo(Vehiculo vehiculo);
}
