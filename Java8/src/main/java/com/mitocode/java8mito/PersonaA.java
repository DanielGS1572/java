package com.mitocode.java8mito;

public interface PersonaA {
	public void caminar();
	
	default public void hablar(){
		System.out.println("La persona habla - Persona A");
	}
}
