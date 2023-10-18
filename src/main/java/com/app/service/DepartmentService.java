package com.app.service;

import com.app.entity.Departement;
import com.app.repository.DepartmentRepository;

import jakarta.persistence.EntityManager;

public class DepartmentService {

	private final DepartmentRepository departmentRepository;
	
	public DepartmentService(EntityManager entityManager) {
		this.departmentRepository = new DepartmentRepository(entityManager);
	}
	public void addDepartment(Departement department) {
		departmentRepository.saveDepartment(department);
	}
}
