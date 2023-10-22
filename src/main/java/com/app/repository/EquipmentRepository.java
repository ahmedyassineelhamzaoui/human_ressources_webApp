package com.app.repository;

import java.util.List;

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
	public List<Equipement> getAllEquipment(){
		return entityManager.createQuery("SELECT e Equipement e",Equipement.class).getResultList();
	}
	public void deleteEquipment(Equipement equipement) {
		entityManager.getTransaction().begin();
		entityManager.remove(equipement);
		entityManager.getTransaction().commit();
	}
	public Equipement findById(long id) {
		return entityManager.find(Equipement.class, id);
	}
}
