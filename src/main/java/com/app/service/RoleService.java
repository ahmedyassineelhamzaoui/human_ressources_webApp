package com.app.service;

import com.app.entity.Role;
import com.app.repository.RoleRepository;
import com.app.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class RoleService {

	private final RoleRepository roleRepository;
    public RoleService(EntityManager entityManager) {
        this.roleRepository = new RoleRepository(entityManager);
    }

    public void createRole(Role role) {
        roleRepository.saveRole(role);
    }
    
}
