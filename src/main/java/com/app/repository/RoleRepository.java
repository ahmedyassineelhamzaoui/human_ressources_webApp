package com.app.repository;

import com.app.entity.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;


public class RoleRepository {

	private final EntityManagerFactory entityManagerFactory;

    public RoleRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void saveRole(Role role) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
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
}