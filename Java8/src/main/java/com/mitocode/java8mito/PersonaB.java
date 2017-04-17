package com.mitocode.java8mito;

public interface PersonaB {
	default public void hablar(){
		System.out.println("La persona habla - Persona B");
	}
}
