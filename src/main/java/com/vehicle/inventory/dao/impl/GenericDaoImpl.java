package com.vehicle.inventory.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vehicle.inventory.dao.GenericDao;
import com.vehicle.inventory.dto.Vehicle;

@Repository
public class GenericDaoImpl implements GenericDao {

	@PersistenceContext
	private EntityManager em;

	private EntityManagerFactory emf;

	private EntityManager getDbConnector() {
		emf = Persistence.createEntityManagerFactory("persistenceUnit");
		em = emf.createEntityManager();
		return em;
	}

	@Override
	public void persist(Object enObj) {
		startTransaction();
		em.persist(enObj);
		commitTransaction();
	}

	private void startTransaction() {
		if (null == em) {
			em = getDbConnector();
		} else {
			em = emf.createEntityManager();
		}
		em.getTransaction().begin();
	}

	private void commitTransaction() {
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public Object read(Class<?> cls, int id) {
		startTransaction();
		Object object = em.find(cls, id);
		commitTransaction();
		return object;
	}

	@Override
	public void remove(Object obj) {
		startTransaction();

		em.remove(obj);
		commitTransaction();

	}

	@Override
	public void merge(Object obj) {
		startTransaction();
		em.merge(obj);
		commitTransaction();
	}

	@Override
	public List<Vehicle> customSelect(String query) {
		return em.createQuery(query).getResultList();
	}

	@Override
	@Transactional
	public void deleteByQuery(String query) {
		startTransaction();
		em.createQuery(query).executeUpdate();
		commitTransaction();
	}

}
