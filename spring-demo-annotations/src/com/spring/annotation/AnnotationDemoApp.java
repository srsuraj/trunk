package com.spring.annotation;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		//read configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from 
		Coach coach = context.getBean("cricketCoach", Coach.class);
		
		VolleyballCoach volleyCoach = context.getBean("volleyballCoach", VolleyballCoach.class);
		
		// call a method from a bean
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		System.out.println(volleyCoach.getDailyWorkout());
		System.out.println(volleyCoach.getDailyFortune());
		System.out.println(volleyCoach.getEmail());
		System.out.println(volleyCoach.getTeamName());
		context.close();
	}

}
