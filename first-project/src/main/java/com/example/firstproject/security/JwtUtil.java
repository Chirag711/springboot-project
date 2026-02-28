package com.example.firstproject.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;


@Component
public class JwtUtil {
	private String SECRET = "thisisaspringapplication";
	
	public String generateToken(String email) {
		return Jwts.builder()
				.setSubject(email)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+10800000))
				.signWith(SignatureAlgorithm.HS256, SECRET)
				.compact();
	}
	
	public String extractEmail(String token) {
		return Jwts.parser()
				.setSigningKey(SECRET)
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
	}
	
}
