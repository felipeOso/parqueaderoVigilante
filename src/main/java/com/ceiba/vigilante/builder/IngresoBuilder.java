package com.ceiba.vigilante.builder;

import com.ceiba.vigilante.dominio.Ingreso;
import com.ceiba.vigilante.entity.IngresoEntity;

public class IngresoBuilder {

	private IngresoBuilder() {}
	
	public static Ingreso convertirADominio(IngresoEntity ingresoEntity) {
		Ingreso ingreso = null;
		if(ingresoEntity != null) {
			ingreso = new Ingreso(VehiculoBuilder.convertirADominio(ingresoEntity.getVehiculo()), ingresoEntity.getHoraIngreso(), ingresoEntity.getTotalPagar(), ingresoEntity.getHoraSalida());
		}
		return ingreso;
	}
	
	public static IngresoEntity convertirAEntity(Ingreso ingreso) {
		IngresoEntity ingresoEntity = new IngresoEntity();
		ingresoEntity.setVehiculo(VehiculoBuilder.convertirAEntity(ingreso.getVehiculo()));
		ingresoEntity.setHoraIngreso(ingreso.getHoraIngreso());
		ingresoEntity.setHoraSalida(ingreso.getHoraSalida());
		ingresoEntity.setTotalPagar(ingreso.getTotalPagar());
		return ingresoEntity;
	}
}
