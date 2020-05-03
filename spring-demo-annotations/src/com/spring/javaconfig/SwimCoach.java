package com.spring.javaconfig;

import com.spring.annotation.Coach;
import com.spring.annotation.FortuneService;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;
	
	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "practice butterfly for 20 min";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getMyFortune();
	}

}
