package com.spring.annotation;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	@Override
	public String getMyFortune() {
		return "it's your Random Service";
	}

}
