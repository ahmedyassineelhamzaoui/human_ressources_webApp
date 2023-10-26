package com.app.repository;

import java.util.List;

import com.app.entity.Role;
import com.app.entity.User;
import com.app.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;


public class RoleRepository {

	private EntityManager entityManager;

    public RoleRepository() {
        entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
    }

    public void saveRole(Role role) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(role);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace(); 
        } finally {
            entityManager.close();
        }
    }
    public List<Role> getAllRoles() {
        return entityManager.createQuery("SELECT r FROM Role r", Role.class).getResultList();
    }
    public void removeRole(Role role) {
    	entityManager.getTransaction().begin();
    	entityManager.remove(role);
    	entityManager.getTransaction().commit();
    }
    public Role findById(long id) {
        return entityManager.find(Role.class, id); 
    }
    public void updateRole(Role role,long id) {
    	Role roleToEdit = entityManager.find(Role.class, id);
		try {
			entityManager.getTransaction().begin();
			roleToEdit.setName(role.getName());
			entityManager.getTransaction().commit();
		}catch(Exception e) {
			if(entityManager.getTransaction().isActive()) 
			{
				entityManager.getTransaction().rollback();
			}
			e.getMessage();
		}
    }
}