package com.app.service;

import java.util.ArrayList;
import java.util.List;

import com.app.entity.Role;
import com.app.entity.User;
import com.app.repository.RoleRepository;
import com.app.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class RoleService {

	private  RoleRepository roleRepository;
	
    public RoleService() {
        this.roleRepository = new RoleRepository();
    }

    public void createRole(Role role) {
        roleRepository.saveRole(role);
    }
    public List<Role> getAllRoles() {
        return roleRepository.getAllRoles();
    }
    public void deleteRole(Role role) {
    	List<User> rolesCopy = new ArrayList<>(role.getUsers());
    	for (User user : rolesCopy) {
            user.removeRole();
        }
         roleRepository.removeRole(role);
    }
    public Role findById(long id) {
    	return roleRepository.findById(id);
    }
    public void updateRole(Role role,long id) {
    	roleRepository.updateRole(role,id);
    }
}
