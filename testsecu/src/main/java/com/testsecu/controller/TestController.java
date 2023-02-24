package com.testsecu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@GetMapping("/user")
	@ResponseBody
	public String testUser() {
		return "TestUser";
	}
	
	@GetMapping("/admin")
	@ResponseBody
	public String testAdmin() {
		return "TestAdmin";
	}
	
	
}
