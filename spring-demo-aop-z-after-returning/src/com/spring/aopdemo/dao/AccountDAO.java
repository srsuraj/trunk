package com.spring.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public void addAcount(Account account, String str) {
		System.out.println(getClass() + ": Adding account in DB DAO");
	}
	
	// add new method: findAccounts()
	
	public List<Account> findAccounts() {
		List<Account> accountLst = new ArrayList<>();	
		
		// create some sample accounts
		Account acc1 = new Account("Mad", "silver");
		Account acc2 = new Account("suraj", "diamond");
		Account acc3 = new Account("Madhu", "gold");
		accountLst.add(acc1);
		accountLst.add(acc2);
		accountLst.add(acc3);
		
		return accountLst;
	}
	
	public boolean needAddAcount() {
		System.out.println(getClass() + ": Validating Account in DAO");
		return true;
	}

	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
}
