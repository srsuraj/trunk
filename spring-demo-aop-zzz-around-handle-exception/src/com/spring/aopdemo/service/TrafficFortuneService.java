package com.spring.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {
		
		// simulate a delay
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// return a fortune
		return "Expected heavy traffic today";
	}

	public String getFortune(boolean tripWire) {
		
		if (tripWire) {
			throw new RuntimeException("Major accident! road is closed");
		}
		return getFortune();
	}
}
