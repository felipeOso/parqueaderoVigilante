package com.ceiba.vigilante.dao;

import java.util.List;

import javax.persistence.Query;

import com.ceiba.vigilante.builder.IngresoBuilder;
import com.ceiba.vigilante.builder.VehiculoBuilder;
import com.ceiba.vigilante.dominio.Ingreso;
import com.ceiba.vigilante.dominio.Vehiculo;
import com.ceiba.vigilante.entity.IngresoEntity;
import com.ceiba.vigilante.persistencia.sistema.SistemaDePersistencia;

public class IngresoDAOImpl implements IngresoDAO {

	private static final String PLACA = "placa";
	private static final String TIPO_VEHICULO = "tipoVehiculo";
	private static final String INGRESO_FIND_BY_PLACA = "Ingreso.findByPlaca";
	private static final String INGRESO_FIND_ALL = "Ingreso.findAll";
	private static final String INGRESO_TIPO_VEHICULO_PARQUEADO = "Ingreso.parking";
	
	SistemaDePersistencia sistemaDePersistencia = new SistemaDePersistencia();

	public IngresoDAOImpl(SistemaDePersistencia sistemaDePersistencia) {
		super();
		this.sistemaDePersistencia = sistemaDePersistencia;
	}

	@Override
	public void agregarIngreso(Ingreso ingreso) {
		this.sistemaDePersistencia.iniciar();
		this.sistemaDePersistencia.getEntityManager().persist(IngresoBuilder.convertirAEntity(ingreso));
		this.sistemaDePersistencia.terminar();
	}

	@Override
	public Vehiculo obtenerIngresoPorPlaca(String placa) {

		IngresoEntity ingresoEntity = obtenerIngresoEntityPorPlacaVehiculo(placa);
		return VehiculoBuilder.convertirADominio(ingresoEntity != null ? ingresoEntity.getVehiculo() : null);

	}

	@SuppressWarnings("unchecked")
	private IngresoEntity obtenerIngresoEntityPorPlacaVehiculo(String placa) {

		Query query = sistemaDePersistencia.getEntityManager().createNamedQuery(INGRESO_FIND_BY_PLACA);
		query.setParameter(PLACA, placa);
		List<IngresoEntity> resultList = query.getResultList();
		return !resultList.isEmpty() ? (IngresoEntity) resultList.get(0) : null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IngresoEntity> obtenerIngresosTotales() {
		return sistemaDePersistencia.getEntityManager().createNamedQuery(INGRESO_FIND_ALL).getResultList();

	}

	@Override
	public int obtenerIngresosPorTipoVehiculoParqueado(String tipoVehiculo) {				
			Query query = sistemaDePersistencia.getEntityManager().createNamedQuery(INGRESO_TIPO_VEHICULO_PARQUEADO);
			query.setParameter(TIPO_VEHICULO, tipoVehiculo);
			List<IngresoEntity> resultList = query.getResultList();
		return !resultList.isEmpty()? resultList.size(): 0;
	}

}
