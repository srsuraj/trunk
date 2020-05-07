package com.spring.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Value("#{genderOptions}")
	private Map<String,String> genderOptions; // this is the way to load drop down value from the properties file
	
	public StudentController() {
		System.out.println("My Student Controller");
	}

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		// create a student object
		Student theStudent = new Student();
		
		// add student object to theModel
		theModel.addAttribute("student", theStudent);
		
		theModel.addAttribute("theGenderOptions", genderOptions);
		
		return "student-form";
	} 
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		// log the input data
		System.out.println(theStudent.getFirstName()+ "   " +theStudent.getLastName());
		
		return "student-confirmation";
	}
}
