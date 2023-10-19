package com.app.repository;

import jakarta.persistence.EntityManager;
import com.app.entity.User;
public class UserRepository {

	private final EntityManager entityManager;
	public UserRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void addUser(User user) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(user);
			entityManager.getTransaction().commit();
		}catch(Exception e) {
			if(entityManager.getTransaction().isActive()){
				entityManager.getTransaction().rollback();
			}
			e.getMessage();
		}finally{
			entityManager.close();
		}
		
		
	}
}
