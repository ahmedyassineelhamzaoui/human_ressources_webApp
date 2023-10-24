package com.app.service;

import com.app.repository.UserRepository;
import java.util.List;
import jakarta.persistence.*;

import com.app.entity.Departement;
import com.app.entity.Role;
import com.app.entity.User;
public class UserService {

	private  UserRepository userRepository;
	
	public UserService() {
	    userRepository = new UserRepository();
	}
	public void addUser(User user) {
		userRepository.addUser(user);
	}
	public List<User> getAllUsers(){
		return userRepository.getAllUsers();
	}
	public User findByUserLogin(String username) {
		return userRepository.findByUserLogin(username);
	}
	public Role findRoleById(long id) {
		return userRepository.findRoleById(id);
	}
	public Departement findDepartementById(long id) {
		return userRepository.findDepartmentById(id);
	}
	public User findUserById(long id) {
		return userRepository.findUserById(id);
	}
	public void updateUser(User user,long id) {
		userRepository.updateUser(user,id);
	}
	public void deleteUser(long id) {
		userRepository.deleteUser(id);
	}
}
