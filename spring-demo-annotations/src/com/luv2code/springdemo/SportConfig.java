package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
// @ComponentScan("com.luv2code.springdemo") // usado para escanear el paquete
@PropertySource("classpath:sport.properties")
public class SportConfig {

	// Para poder resolver ${..} se debe crear el siguiente Bean
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	// definir los metodos que exponen para obtener los beans
	// Ademas aqui se estan definiendo los beans
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}

	// definir los metodos que exponen para obtener los beans
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
