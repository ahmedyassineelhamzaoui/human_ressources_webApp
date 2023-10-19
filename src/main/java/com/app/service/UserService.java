package com.app.service;

import com.app.repository.UserRepository;
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
}
