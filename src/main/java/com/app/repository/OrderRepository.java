package com.app.repository;

import com.app.util.HibernateUtil;

import jakarta.persistence.EntityManager;
public class OrderRepository {

	private EntityManager entityManager;
	public OrderRepository() {
		this.entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
	}
}
