package com.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	// need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	
	@RequestMapping("/processFormV2")
	public String processFormV2(HttpServletRequest request, Model model) {
		// read the request parameter from the HTML form
		String name = request.getParameter("studentName");
		name = name.toUpperCase();
		name = "Yo! ".concat(name);
		//add message to the model
		model.addAttribute("message", name);
		return "helloworld";
	}
	
	@RequestMapping("/processFormV3")
	public String processFormV3(@RequestParam("studentName") String name, Model model) {
		// read the request parameter from the HTML form
		name = name.toUpperCase();
		name = "Yo yo! ".concat(name);
		//add message to the model
		model.addAttribute("message", name);
		return "helloworld";
	}
}
