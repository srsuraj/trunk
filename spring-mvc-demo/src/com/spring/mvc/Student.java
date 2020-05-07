package com.spring.mvc;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Student {

	private String firstName;
	private String lastName;
	private String country;
	private String occupation;
	private String gender;
	private String favLang;
	private String[] carBrand;
	private Map<String,String> countryOptions;
	private LinkedHashMap<String, String> carBrands;
	
	public Student() {
		countryOptions = new HashMap<>();
		carBrands = new LinkedHashMap<>();
		//
		countryOptions.put("BR", "BRAZIL");
		countryOptions.put("IN", "India");
		countryOptions.put("US", "USA");
		countryOptions.put("FR", "France");
		countryOptions.put("DE", "Germany");
		//
		carBrands.put("Audi", "Audi");
		carBrands.put("BMW", "BMW");
		carBrands.put("Mercedes", "Mercedes");
		carBrands.put("Skoda", "Skoda");
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Map<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFavLang() {
		return favLang;
	}

	public void setFavLang(String favLang) {
		this.favLang = favLang;
	}

	public String[] getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String[] carBrand) {
		this.carBrand = carBrand;
	}

	public LinkedHashMap<String, String> getCarBrands() {
		return carBrands;
	}
	
	
}
