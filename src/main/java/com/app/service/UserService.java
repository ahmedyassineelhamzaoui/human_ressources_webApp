package com.app.service;

import com.app.repository.UserRepository;
import java.util.List;
import jakarta.persistence.*;
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
}
