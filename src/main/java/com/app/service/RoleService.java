package com.app.service;

import com.app.entity.Role;
import com.app.repository.RoleRepository;
import com.app.util.HibernateUtil;

import jakarta.persistence.EntityManagerFactory;

public class RoleService {

	private final RoleRepository roleRepository;
    private final EntityManagerFactory entityManagerFactory;

    public RoleService() {
        this.entityManagerFactory = HibernateUtil.getEntityManagerFactory();
        this.roleRepository = new RoleRepository(entityManagerFactory);
    }

    public void createRole(Role role) {
        roleRepository.saveRole(role);
    }
}
