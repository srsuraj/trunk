package com.spring.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.spring.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAcount(Account account, String str) {
		System.out.println(getClass() + ": Adding account in DB DAO");
	}
	
	public boolean needAddAcount() {
		System.out.println(getClass() + ": Validating Account in DAO");
		return true;
	}

}
