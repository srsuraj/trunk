package com.spring.annotation;

import org.springframework.stereotype.Component;

@Component
public class RESTFortuneService implements FortuneService {

	@Override
	public String getMyFortune() {
		return "REST fortune Service";
	}

}
