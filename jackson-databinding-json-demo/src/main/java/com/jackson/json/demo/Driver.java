package com.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			
			// create a object mapper
			ObjectMapper obj = new ObjectMapper();
			
			// read json file and map/convert to java POJO:
			// data/sample-lite.json
			Student theStudent = obj.readValue(new File("data/sample-full.json"), Student.class);
			
			// print first name and last name
			System.out.println("Name of the Student is: "+ theStudent.getFirstName() + " " + theStudent.getLastName());
			System.out.println("languages are: ");
			String[] lang = theStudent.getLanguages();
			for(int i=0; i<lang.length; i++) {
				System.out.println(lang[i]);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
