package com.mitocode.java8mito;

public class Sintaxis {
	public void calculaPromedio() {
		Operacion operacion = (x, y) -> (x + y) / 2;  //puede no llevar la palabra return

		Operacion operacion2 = (x, y) -> {
			return (x + y) / 2;
		};
		System.out.println(operacion2.promedio(2, 5));
	}

	public static void main(String[] args) {
		Sintaxis sintaxis = new Sintaxis();
		sintaxis.calculaPromedio();
	}
}
