package com.spring.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		// load spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//get bean from spring container
		Coach coach = context.getBean("cricketCoach", Coach.class);
		
		Coach theCoach = context.getBean("cricketCoach", Coach.class);
		
		boolean result = coach == theCoach;
		
		System.out.println(result);
		System.out.println("coach object is -- " + coach);
		System.out.println("theCoach object is -- " + theCoach);

	}

}
