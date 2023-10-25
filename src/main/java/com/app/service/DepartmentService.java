package com.app.service;

import com.app.entity.Departement;
import com.app.entity.User;
import com.app.repository.DepartmentRepository;

import java.util.ArrayList;
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
		 List<User> usersCopy = new ArrayList<>(department.getUsers());
	        for (User user : usersCopy) {
	            user.removeDepartment();
	        }
		departmentRepository.deleteDepartment(department);
	}
	public Departement findById(long id) {
		return departmentRepository.findById(id);
	}
}
