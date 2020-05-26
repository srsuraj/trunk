package com.spring.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO dao = context.getBean("accountDAO", AccountDAO.class);
		
		// call method to get the accounts
		List<Account> accounts = dao.findAccounts();
		
		// display the accounts
		System.out.println("\n\nMain Program: AfterReturningDemoApp");
		System.out.println("------");
		
		System.out.println(accounts + "\n");
		
		// close the context
		context.close();

	}

}
