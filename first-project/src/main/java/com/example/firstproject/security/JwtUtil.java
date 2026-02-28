package com.example.firstproject.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;


@Component
public class JwtUtil {
	private static final String SECRET = "mysecretkeymysecretkeymysecretkeymysecretkey";

    public String generateToken(String email) {

        SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes());

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 10800000))
                .signWith(key)
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
