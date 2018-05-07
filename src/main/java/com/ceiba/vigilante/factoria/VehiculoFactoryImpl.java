package com.ceiba.vigilante.factoria;

import com.ceiba.vigilante.dominio.Carro;
import com.ceiba.vigilante.dominio.Moto;
import com.ceiba.vigilante.dominio.Vehiculo;

public class VehiculoFactoryImpl implements VehiculoFactory {

	public static final String TIPO_MOTO = "moto";

	@Override
	public Vehiculo crearTipoVehiculo(Vehiculo vehiculo) {
		if (vehiculo.getTipoVehiculo() == TIPO_MOTO) {
			return new Moto(vehiculo.getPlaca(),vehiculo.getTipoVehiculo(),vehiculo.getCilindraje());
		} else {
			return new Carro(vehiculo.getPlaca(), vehiculo.getTipoVehiculo());
		}
	}

}
