package com.spring.demo;

public class BaseballCoach implements MyCoach {

	FortuneService fortuneService;
	
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String myTraining() {
		return "practice batting for 30 min";
	}

	@Override
	public String myFortune() {
		return fortuneService.getMyFortune();
	}
	
	// add an init method
	public void doMyStartup() {
		System.out.println("My Startup method");
	}

	//add destroyer method
	public void doMyCleanup() {
		System.out.println("My cleanup method");
	}
}
