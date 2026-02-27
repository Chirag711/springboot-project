package com.example.firstproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.firstproject.model.User;
import com.example.firstproject.repository.UserRepository;

@Service
public class UserService {
		
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public Optional<User> getUserById(String id){
		return userRepository.findById(id);
	}
	
	public User updateUser(String id, User user) {
		return userRepository.save(user);
	}
	
	public boolean deleteUser(String id) {
		if(userRepository.existsById(id)) {
			userRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
		
	}
}
