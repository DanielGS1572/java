package com.mitocode.java8mito;

public class DefaultMethod implements PersonaA,PersonaB {
	@Override
	public void caminar() {
		System.out.println("La persona camina");
	}

	@Override
	public void hablar() {
		PersonaA.super.hablar();	//si existen dos interfaces con el mismo metodo
		//el ide no sabrá cual utilizar por lo que se tiene que especificar
		//en caso que no se quiera usar ninguna de las interfaces simplemente se quita la instrucción
	}

	public static void main(String[] args) {
		DefaultMethod dM = new DefaultMethod();
		dM.hablar();
		

	}

}
