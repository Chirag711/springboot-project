package com.example.firstproject.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.firstproject.model.User;
import com.example.firstproject.repository.UserRepository;
import com.example.firstproject.security.JwtUtil;

@Service
public class AuthService {
	@Autowired
	private UserRepository repo;
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private EmailService emailService;
	
	public String register(User user) {
		repo.save(user);
		return "User registered";
	}
	
	public String login(String email, String password) {
		User user = repo.findByEmail(email);
		
		if(user == null) {
			return "user not found";
		}
		if(user!=null && user.getPassword().equals(password)) {
			return jwtUtil.generateToken(user.getEmail());
		}
		return "Invlid Credentials";
	}
	
	public String forgotPassword(String email) {
		User user = repo.findByEmail(email);
		if(user == null) {
			return "user not found";
		}
		String token = UUID.randomUUID().toString();
		user.setResetToken(token);
		repo.save(user);
		String link = "http://localhost:8089/reset-password?token="+token;
		emailService.sendEmail(user.getEmail(), "Reset Passowrd", link);
		return "reset link sent to email";
	}
	
	public String resetPassword(String token, String password) {
		User user = repo.findByResetToken(token);
		if(user == null) {
			return "Invalid token...";
		}
		
		System.out.println("old password -> "+user.getPassword());
		System.out.println("new password -> "+ password);
		user.setPassword(password);
		user.setResetToken(null);
		repo.save(user);
		return "Password updated...";
	}
	
}
