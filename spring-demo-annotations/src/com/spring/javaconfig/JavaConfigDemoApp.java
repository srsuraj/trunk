package com.spring.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.annotation.Coach;
import com.spring.annotation.VolleyballCoach;

public class JavaConfigDemoApp {

	public static void main(String[] args) {

		//read configuration file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from 
		Coach coach = context.getBean("swimCoach", Coach.class);
		
		
		// call a method from a bean
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		context.close();
	}

}
