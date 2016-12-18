package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		//leer el archivo de java
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		//Obtener el bean del contenedor de spring
		SwimCoach theCoach = context.getBean("swimCoach",SwimCoach.class);
		
		//llamar los metodos del bean
		System.out.println(theCoach.getDailyWorkout());
		
		
		//Constructor Injection --> se debe de implementar la interfaz y hacer override
		//no cambia la forma en la que se manda llamar el metodo con el bean
		//ya sea constructor o setter siempre sera igual
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println("email " + theCoach.getEmail());
		System.out.println("team " + theCoach.getTeam());
		
		//cerar el contexto
		context.close();

	}

}
