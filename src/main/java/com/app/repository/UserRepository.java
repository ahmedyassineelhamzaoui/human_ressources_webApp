package com.app.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import com.app.util.HibernateUtil;
import com.app.entity.Departement;
import com.app.entity.Role;
import com.app.entity.User;
import java.util.List;
public class UserRepository {

	private  EntityManager entityManager;
	public UserRepository() {
		entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
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
	public Role findRoleById(long id) {
		return entityManager.find(Role.class, id);
	}
	public Departement findDepartmentById(long id) {
		return entityManager.find(Departement.class, id);
	}
	public User findUserById(long id) {
		return entityManager.find(User.class, id);
	}
	public void updateUser(User user,long id) {
		User userToEdit = entityManager.find(User.class, id);
		try {
			entityManager.getTransaction().begin();
			userToEdit.setFirstName(user.getFirstName());
			userToEdit.setLastName(user.getLastName());
			userToEdit.setEmail(user.getEmail());
			userToEdit.setPosition(user.getPosition());
			userToEdit.setRole(user.getRole());
			userToEdit.setDepartment(user.getDepartment());
			entityManager.getTransaction().commit();
		}catch(Exception e) {
			if(entityManager.getTransaction().isActive()) 
			{
				entityManager.getTransaction().rollback();
			}
			e.getMessage();
		}
	}
	public void deleteUser(long id) {
		entityManager.getTransaction().begin();
		User u = entityManager.find(User.class, id);
		entityManager.remove(u);
		entityManager.getTransaction().commit();
	}
}
