package com.spring.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:sport.properties")
public class VolleyballCoach implements Coach {
	
	@Value("${coach.email}")
	private String email;
	
	@Value("${coach.teamName}") // variable injection from properties file
	private String teamName;
	
	// define my init method
	@PostConstruct
	public void doStratup() {
		System.out.println("startup method it is..");
	}
	
	// define my destroy method
	@PreDestroy
	public void doDestroy() {
		System.out.println("cleanup method it is...");
	}
	
	@Autowired
	@Qualifier("databaseFortuneService")
	FortuneService fortuneService; // field injection dependency with annotation
	
	/* @Autowired
	public void setFortuneService(FortuneService fortuneService) { // setter injection
		this.fortuneService = fortuneService;
	} */

	@Override
	public String getDailyWorkout() {
		return "practice boosting practice for 20 min";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getMyFortune();
	}

	public String getEmail() {
		return email;
	}

	public String getTeamName() {
		return teamName;
	}

}
