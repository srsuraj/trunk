package com.spring.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		// Loading Spring Config File
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// retrieve bean from Spring container
		MyCoach coach = context.getBean("myCoach", MyCoach.class); // for constructor injection
		
		MyCoach boxing = context.getBean("boxCoach", MyCoach.class); // for setter injection
		//call method on bean object for constructor injection
		System.out.println(coach.myTraining());
		System.out.println(coach.myFortune());
		//call method on bean object for setter injection
		System.out.println(boxing.myTraining());
		System.out.println(boxing.myFortune());
		//close the context
		context.close();
	}

}
