package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

//@Component("thatSillyCoach") // Si no se especifica el nombre del bean toma un
								// valor por default que es el nombre de la
								// clase con la primer letra minuscula
@Component
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice your backhand volley";
	}

}
