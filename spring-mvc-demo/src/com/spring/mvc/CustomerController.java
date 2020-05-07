package com.spring.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		theModel.addAttribute("customer", new Customer());
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult) {
		
		System.out.println("Last name: |" + theCustomer.getLastName() +"|");
		if (theBindingResult.hasErrors()) {
			return "customer-form";
		} else {
		return "customer-confirmation";
		}
	}
	
	// add an initBinder ... to convert trim input strings (it will intercept all request)
	// remove leading and trailing whitespace
	// resolve issue for whitespace for not null field
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor trimmer = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, trimmer);
		
	}
}
