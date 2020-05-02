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
	

}
