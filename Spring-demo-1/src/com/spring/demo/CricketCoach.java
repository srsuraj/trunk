package com.spring.demo;

public class CricketCoach implements MyCoach {

	private String email;
	private String teamName;
	private FortuneService fortuneService;
	
	public CricketCoach() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String myTraining() {
		return "Do batting practice for 40 min.";
	}

	@Override
	public String myFortune() {
		return fortuneService.getMyFortune();
	}

}
