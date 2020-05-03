package com.spring.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.spring.annotation.Coach;
import com.spring.annotation.FortuneService;
import com.spring.annotation.RandomFortuneService;

@Configuration
//@ComponentScan("com.spring.annotation") //if not provide then we have to define the bean for individual class
public class SportConfig {
	
	// define fortune service bean
	@Bean
	public FortuneService randomFortune() {
		return new RandomFortuneService();
	}
	
	// define bean for our swim coach and inject fortune service dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(randomFortune());
	}
}
