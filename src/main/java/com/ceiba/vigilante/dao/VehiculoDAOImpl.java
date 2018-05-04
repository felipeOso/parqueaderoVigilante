package com.ceiba.vigilante.dao;

import com.ceiba.vigilante.builder.VehiculoBuilder;
import com.ceiba.vigilante.dominio.Vehiculo;
import com.ceiba.vigilante.persistencia.sistema.SistemaDePersistencia;



public class VehiculoDAOImpl implements VehiculoDAO{

	//private static final String VEHICULO_FIND_ALL = "Vehiculo.findAll";
	private SistemaDePersistencia sistemaDePersistencia;

	public VehiculoDAOImpl(SistemaDePersistencia sistemaDePersistencia) {
		this.sistemaDePersistencia = sistemaDePersistencia;
	}

	@Override
	public void agregarVehiculo(Vehiculo vehiculo) {
		sistemaDePersistencia.getEntityManager().persist(VehiculoBuilder.convertirAEntity(vehiculo));
	}

//	@Override
//	public List<Vehiculo> obtenerVehiculosTotales() {
//		return null;
//	
//	}

/*	@Override
	public List<VehiculoEntity> obtenerVehiculoEntityTotales() {
		List<VehiculoEntity> listaVehiculosEntity = entityManager.createNamedQuery(VEHICULO_FIND_ALL).getResultList();
	return listaVehiculosEntity;
	}*/

}
