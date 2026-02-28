package com.example.firstproject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.firstproject.model.User;

public interface UserRepository extends MongoRepository<User,String> {
	User findByEmail(String email);
	
	User findByResetToken(String token);
}
