package com.spring.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleDemoApp {

	public static void main(String[] args) {
		//  load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifecycle-applicationContext.xml");
		
		// retrieve bean from spring container
		MyCoach theCoach = context.getBean("myCoach", MyCoach.class);
		
		System.out.println(theCoach.myTraining());
		
		context.close();

	}

}
