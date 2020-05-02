package com.spring.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		//  load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		// retrieve bean from spring container
		MyCoach theCoach = context.getBean("myCoach", MyCoach.class);
		
		MyCoach alphaCoach = context.getBean("myCoach", MyCoach.class);
		
		// check if both the object are same i.e singleton object
		
		boolean result = (theCoach == alphaCoach);
		System.out.println(result);
		System.out.println(theCoach);
		System.out.println(alphaCoach);
		
		context.close();

	}

}
