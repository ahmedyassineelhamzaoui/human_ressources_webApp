package com.app.repository;

import com.app.entity.Equipement;
import com.app.util.HibernateUtil;

import jakarta.persistence.EntityManager;

public class EquipmentRepository {

	private EntityManager entityManager;
	public EquipmentRepository() {
		entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
	}
	public void AddEquipment(Equipement equipment) {
		try {
		     entityManager.getTransaction().begin();
		     entityManager.persist(equipment);
		     entityManager.getTransaction().commit();
		}catch(Exception e) {
			if(entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
		}finally {
			entityManager.close();
		}
	}
}
