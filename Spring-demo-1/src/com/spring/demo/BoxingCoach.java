package com.spring.demo;

public class BoxingCoach implements MyCoach {

	private FortuneService fortuneService;

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String myTraining() {
		return "Practice Upper cut for 10 minutes";
	}
	
	@Override
	public String myFortune() {
		return fortuneService.getMyFortune();
	}

}
