package com.ceiba.vigilante.persistencia.conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexionJPA {
	private static final String VIGILANTE_PU_TEST = "vigilante-pu-test";
	private static EntityManagerFactory entityManagerFactory;

	public ConexionJPA() {
		entityManagerFactory = Persistence.createEntityManagerFactory(VIGILANTE_PU_TEST);
	}
	
	public EntityManager createEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
}
