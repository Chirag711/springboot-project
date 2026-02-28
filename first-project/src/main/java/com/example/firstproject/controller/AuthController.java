package com.example.firstproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstproject.dto.LoginRequest;
import com.example.firstproject.dto.ResetPasswordRequest;
import com.example.firstproject.model.User;
import com.example.firstproject.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private AuthService service;

	@PostMapping("/register")
	public String register(@RequestBody User user) {
		return service.register(user);
	}
	@PostMapping("/login")
	public String login(@RequestBody LoginRequest request ) {
		return service.login(request.getEmail(), request.getPassword());
	}
	@PostMapping("/forgot-password")
	public String forgotPassword(@RequestBody LoginRequest request) {
		return service.forgotPassword(request.getEmail());
	}
	@PostMapping("/reset-password")
	public String resetPassword(@RequestBody ResetPasswordRequest req) {
		
		return service.resetPassword(req.getToken(), req.getPassword());
	}
}
