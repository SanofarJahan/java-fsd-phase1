package com.simplilearn.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@GetMapping("/")
	
	public String Hello() {
		return "welcome to amazon ec2 online application made with springboot";
		
	}

}