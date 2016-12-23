package com.example.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mitocode.beans.Mundo;

public class App {

	public static void main(String[] args) {
		// ApplicationContext appContext = new
		// ClassPathXmlApplicationContext("com/mitocode/xml/beans.xml"); // si
		// estuviera
		// en
		// el
		// mismo
		// paquete
		// se
		// puede
		// quitar
		// esta
		// instruccion
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppAnotaciones.class); // Ahora
																										// no
																										// se
																										// hace
																										// con
																										// un
																										// xml
																										// si
																										// no
																										// con
																										// una
																										// anotacion,
																										// que
																										// sustituye
																										// la
																										// instrucción
																										// en
																										// xml

		Mundo m = (Mundo) appContext.getBean("mundo"); // el llamado también
		// puede ser a trabes del nombre del bean
		// Mundo m = appContext.getBean(Mundo.class);

		System.out.println(m.getSaludo());
		((ConfigurableApplicationContext) appContext).close();
	}

}
