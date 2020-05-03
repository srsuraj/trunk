package com.spring.annotation;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getMyFortune() {
		return "Today is your Lucky day!";
	}

}
