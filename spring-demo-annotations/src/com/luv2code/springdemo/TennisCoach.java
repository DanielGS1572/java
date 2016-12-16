package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach") // Si no se especifica el nombre del bean toma un
// valor por default que es el nombre de la
// clase con la primer letra minuscula
@Component
public class TennisCoach implements Coach {
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

	// // ############### CONSTRUCTOR
	// @Autowired
	// public TennisCoach(FortuneService theFortuneService) {
	// fortuneService = theFortuneService;
	// }

	// ############### SETTER (en realidad puede ser cualquier nombre de metodo)
	public TennisCoach() {
		System.out.println("Constructor >> tennisCoach");
	}

	//init method
	@PostConstruct
	public void doMyStartUpStuff(){
		System.out.println(">> TennisCoach inside of doMyStartUpStuff");
	}
	@PreDestroy
	public void doMyCleanUpStuff(){
		System.out.println(">> TennisCoach inside of doMyCleanUpStuff");
	}
	
	// @Autowired
	// public void setFortunService(FortuneService theFortuneService){
	// System.out.println("Setter >> tennisCoach");
	// fortuneService = theFortuneService;
	// }

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
