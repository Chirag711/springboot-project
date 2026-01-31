package com.example.firstproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

	@GetMapping("/test")
	public String test() {
		return "Hello this is a first API end point";
	}
	
	@GetMapping("/sample")
	public String test1() {
		return "Hello sample";
	}
	
	@GetMapping("/user/{name}/{laptop}")
	public String welcomeUser(@PathVariable String name,@PathVariable String laptop) {
		return "Welcome " + name + " " + laptop;
	}
	
	@GetMapping("/user")
	public String greet(@RequestParam(required = false) String name) {
		return name != null ? "Welcome "+name : "Welcome Guest!!!!";
	}
	
	@GetMapping("/city")
	public String city(@RequestParam(defaultValue = "Mumbai") String city) {
		return "city" + city;
	}
	
	
	
}
