package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	private String fortune[] = {"fortune 1","fortune 2","fortune 3"};
	
	private Random math = new Random();

	@Override
	public String getFortune() {
		int index = math.nextInt(fortune.length);
		
		return fortune[index];
	}

}
