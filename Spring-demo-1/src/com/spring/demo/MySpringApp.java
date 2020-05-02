package com.spring.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySpringApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// retrieve bean from Spring container
		CricketCoach cricketCoach = context.getBean("cricCoach", CricketCoach.class); // for setter injection
		System.out.println(cricketCoach.myTraining());
		System.out.println(cricketCoach.myFortune());
		System.out.println(cricketCoach.getEmail());
		System.out.println(cricketCoach.getTeamName());
		context.close();
	}

}
