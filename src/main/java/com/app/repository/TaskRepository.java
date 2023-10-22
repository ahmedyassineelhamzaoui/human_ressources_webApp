package com.app.repository;

import com.app.util.HibernateUtil;

import jakarta.persistence.EntityManager;

public class TaskRepository {

	private EntityManager entityManager;
	
	public TaskRepository() {
		this.entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
	}
}
