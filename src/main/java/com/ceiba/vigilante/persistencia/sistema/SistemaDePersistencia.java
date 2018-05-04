package com.ceiba.vigilante.persistencia.sistema;

import javax.persistence.EntityManager;

import com.ceiba.vigilante.persistencia.conexion.ConexionJPA;



public class SistemaDePersistencia {

	private EntityManager entityManager;

	public SistemaDePersistencia() {
		this.entityManager = new ConexionJPA().createEntityManager();
	}
	public void iniciar() {
		entityManager.getTransaction().begin();
	}

	public void terminar() {
		entityManager.getTransaction().commit();
	}
	public EntityManager getEntityManager() {
		return entityManager;
	}
}
