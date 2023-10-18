package com.app.repository;

import com.app.entity.Departement;

import jakarta.persistence.EntityManager;

public class DepartmentRepository {

	private final EntityManager entityManager;
	
	public DepartmentRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	public void saveDepartment(Departement department) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(department);
			entityManager.getTransaction().commit();
		}catch(Exception e) {
			if(entityManager.getTransaction().isActive())
			{
				entityManager.getTransaction().rollback();
			}
			e.getMessage();
		}finally {
			entityManager.close();
		}
	}
}
