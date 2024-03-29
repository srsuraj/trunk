package com.spring.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO dao = context.getBean("accountDAO", AccountDAO.class);
		List<Account> accounts = null;
		// call method to get the accounts
		try {
			// add a boolean flag to simulate exception
			boolean tripWire = false;
			accounts = dao.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("\n\nMain Program caught Exception " + e);
		}
		
		// display the accounts
		System.out.println("\n\nMain Program: AfterThrowingDemoApp");
		System.out.println("------");
		
		System.out.println(accounts + "\n");
		
		// close the context
		context.close();

	}

}
