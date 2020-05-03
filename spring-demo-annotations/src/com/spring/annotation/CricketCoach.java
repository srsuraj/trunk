package com.spring.annotation;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // it will create new object every time 
public class CricketCoach implements Coach,DisposableBean {
	
	private FortuneService fortuneService;
	
	@Autowired
	public CricketCoach(@Qualifier("randomFortuneService") FortuneService fortuneService) { //constructor injection
		this.fortuneService = fortuneService;
	} 

//	@Autowired
//	@Qualifier("randomFortuneService")
//	public void doFortune(FortuneService fortuneService) { // method injection
//		this.fortuneService = fortuneService;
//	} 
	
	@Override
	public String getDailyWorkout() {
		return "practice for short balls";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getMyFortune();
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("predestroy method for prototype bean scope...");
	}

}
