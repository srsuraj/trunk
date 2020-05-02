package com.spring.demo;

import java.util.Random;
import java.util.SplittableRandom;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getMyFortune() {
		String []fortune = new String[5];
		fortune[0] = "Bad Day! Be Carefull";
		fortune[1] = "Lucky Day for you";
		fortune[2] = "sad day for you";
		fortune[3] = "money day for you";
		fortune[4] = "romantic day for you";
    
		SplittableRandom random = new SplittableRandom();

		return fortune[random.nextInt(0, 5)];
	}

}
