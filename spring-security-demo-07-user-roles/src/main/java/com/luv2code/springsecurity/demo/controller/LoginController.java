package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/showmyloginpage")
	public String showMyLoginPage() {
		return "fancy-login";
	}
	
	// add a request mapping for access denied
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		return "access-denied";
	}

}
