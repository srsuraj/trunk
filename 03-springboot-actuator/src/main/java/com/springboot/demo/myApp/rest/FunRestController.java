package com.springboot.demo.myApp.rest;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	// expose "/" that return "Hello World"
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World! Time on server is " + LocalDate.now();
	}
	
	// add new end point for "workout"
	@GetMapping("/workout")
	public String workout() {
		return "Run hard 5 Km";
	}

}
