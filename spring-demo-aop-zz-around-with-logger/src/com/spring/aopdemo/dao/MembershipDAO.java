package com.spring.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public boolean addDefaultMember() {
		System.out.println(getClass() + ": Doing my DB work in membership class");
		return true;
	}

}
