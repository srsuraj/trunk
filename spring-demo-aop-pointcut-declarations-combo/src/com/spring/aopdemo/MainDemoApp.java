package com.spring.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aopdemo.dao.AccountDAO;
import com.spring.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO dao = context.getBean("accountDAO", AccountDAO.class);
		
		MembershipDAO memberDao = context.getBean("membershipDAO", MembershipDAO.class);
		
		// call the business method
		Account account = new Account();
		dao.addAcount(account, "s");
		dao.needAddAcount();
		
		// call the accountdao getter and setter methods
		dao.getName();
		dao.setName("suraj");
		dao.getServiceCode();
		dao.setServiceCode("jdbc service");
		
		memberDao.addDefaultMember();
		
		// close the context
		context.close();

	}

}
