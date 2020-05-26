package com.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> studentLst;
	
	@PostConstruct
	public void loadData() {
		studentLst = new ArrayList<>();
		studentLst.add(new Student("richa", "madhupriya"));
		studentLst.add(new Student("suraj", "singh"));
		studentLst.add(new Student("ram", "mohan"));
	}
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		return studentLst;
	}
	
	// define endpoint for "/students/{studentId}" - return at index
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		if (studentId >= studentLst.size() || studentId < 0) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}
		return studentLst.get(studentId);
	}

}
