package com.app.service;

import com.app.entity.Departement;
import com.app.repository.DepartmentRepository;
import java.util.List;
import jakarta.persistence.EntityManager;

public class DepartmentService {

	private  DepartmentRepository departmentRepository;
	
	public DepartmentService() {
		this.departmentRepository = new DepartmentRepository();
	}
	public void addDepartment(Departement department) {
		departmentRepository.saveDepartment(department);
	}
	public List<Departement> getAllDepartment(){
		return departmentRepository.getAllDepartments();
	}
	public void removeDepartment(Departement department) {
		departmentRepository.deleteDepartment(department);
	}
}
