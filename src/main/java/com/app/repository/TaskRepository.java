package com.app.repository;

import com.app.entity.Task;
import com.app.util.HibernateUtil;

import jakarta.persistence.EntityManager;

public class TaskRepository {

	private EntityManager entityManager;
	
	public TaskRepository() {
		this.entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
	}
	public void addTask(Task task) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(task);
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
