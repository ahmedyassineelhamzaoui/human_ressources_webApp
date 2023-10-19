package com.app.service;

import com.app.repository.UserRepository;
import java.util.List;
import jakarta.persistence.*;
import com.app.entity.User;
public class UserService {

	private final UserRepository userRepository;
	
	public UserService(EntityManager entityManager) {
	    userRepository = new UserRepository(entityManager);
	}
	public void addUser(User user) {
		userRepository.addUser(user);
	}
	public List<User> getAllUsers(){
		return userRepository.getAllUsers();
	}
	public User findByUserName(String username) {
		return userRepository.findByUsername(username);
	}
}
