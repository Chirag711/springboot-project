package com.example.firstproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	public String login(@RequestParam String email, @RequestParam String password) {
		return service.login(email, password);
	}
	@PostMapping("/forgot-password")
	public String forgotPassword(@RequestParam String email) {
		return service.forgotPassword(email);
	}
	@PostMapping("/reset-password")
	public String resetPassword(@RequestParam String token, @RequestParam String password) {
		return service.resetPassword(token, password);
	}
}
