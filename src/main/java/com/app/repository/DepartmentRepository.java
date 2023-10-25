package com.app.repository;

import com.app.entity.Departement;
import com.app.util.HibernateUtil;

import java.util.List;
import jakarta.persistence.EntityManager;

public class DepartmentRepository {

	private  EntityManager entityManager;
	
	public DepartmentRepository() {
		entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
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
		}
	}
	public List<Departement> getAllDepartments(){
		return entityManager.createQuery("SELECT d FROM Departement d",Departement.class).getResultList();
	}
	public void deleteDepartment(Departement department) {
		entityManager.getTransaction().begin();
		entityManager.remove(department);
		entityManager.getTransaction().commit();
	}
	public Departement findById(long id) {
		return entityManager.find(Departement.class, id);
	}
}
