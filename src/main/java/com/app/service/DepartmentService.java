package com.app.service;

import com.app.entity.Departement;
import com.app.repository.DepartmentRepository;
import java.util.List;
import jakarta.persistence.EntityManager;

public class DepartmentService {

	private final DepartmentRepository departmentRepository;
	
	public DepartmentService(EntityManager entityManager) {
		this.departmentRepository = new DepartmentRepository(entityManager);
	}
	public void addDepartment(Departement department) {
		departmentRepository.saveDepartment(department);
	}
	public List<Departement> getAllDepartment(){
		return departmentRepository.getAllDepartments();
	}
}
