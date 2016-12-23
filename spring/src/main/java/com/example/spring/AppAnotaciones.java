package com.example.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mitocode.beans.Mundo;

@Configuration
public class AppAnotaciones {
	
	@Bean 	//Viene siendo la etiqueta de la definición del bean dentro del xml
	public Mundo mundo() {
		return new Mundo();
	}
	
}
