package com.app.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import com.app.entity.User;
import java.util.List;
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
	public List<User> getAllUsers(){
		return entityManager.createQuery("SELECT u FROM User u",User.class).getResultList();
		
	}
	public User findByUserLogin(String userLogin) {
		TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username OR u.email = :email",User.class);
		query.setParameter("username",userLogin);
		query.setParameter("email", userLogin);
		try {
	        return query.getSingleResult();
	    } catch (NoResultException e) {
	        return null; 
	    }
	}
}
