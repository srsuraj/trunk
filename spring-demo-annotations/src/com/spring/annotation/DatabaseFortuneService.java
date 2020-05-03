package com.spring.annotation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {
	List<String> fortune;
	
	@Override
	public String getMyFortune() {
		Random random = new Random();
		int i = random.nextInt(fortune.size());
		return fortune.get(i);
	}
	
	@PostConstruct
	public void loadFortunefromFile() {
		try {
			fortune = new ArrayList<String>();
			FileReader fReader = new FileReader("src/myfile.txt");
			BufferedReader br = new BufferedReader(fReader);
			String line = br.readLine();
			while(line != null) {
				fortune.add(line);
				line = br.readLine();
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}
