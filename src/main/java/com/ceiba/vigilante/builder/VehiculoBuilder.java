package com.ceiba.vigilante.builder;

import com.ceiba.vigilante.dominio.Vehiculo;
import com.ceiba.vigilante.entity.VehiculoEntity;

public class VehiculoBuilder {

	private VehiculoBuilder() {}
	
	public static Vehiculo convertirADominio(VehiculoEntity vehiculoEntity) {
		Vehiculo vehiculo = null;
		if(vehiculoEntity != null) {
			vehiculo = new Vehiculo(vehiculoEntity.getTipoVehiculo(), vehiculoEntity.getPlaca()) {
			};
		}
		return vehiculo;
	}
	
	public static VehiculoEntity convertirAEntity(Vehiculo vehiculo) {
		VehiculoEntity vehiculoEntity = new VehiculoEntity();
		
		vehiculoEntity.setTipoVehiculo(vehiculo.getTipoVehiculo());
		vehiculoEntity.setPlaca(vehiculo.getPlaca());	
		return vehiculoEntity;
	}
}
