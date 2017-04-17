package com.mitocode.java8mito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class LambdaApp {
	public void ordenar() {
		List<String> lista = new ArrayList<>();
		lista.add("MitoCode");
		lista.add("Code");
		lista.add("Mito");

		Collections.sort(lista, new Comparator<String>() {
			@Override
			public int compare(String arg0, String arg1) {
				return arg0.compareTo(arg1);
			}
		});
		System.out.println("para JKD anterior a la 8");
		for (String list : lista) {
			System.out.println(list);
		}

		System.out.println();
		System.out.println();

		List<String> lista2 = new ArrayList<>();
		lista2.add("MitoCode");
		lista2.add("Code");
		lista2.add("Mito");
		Collections.sort(lista2, (String s1, String s2) -> s1.compareTo(s2));

		System.out.println("para JKD  8");
		for (String list : lista2) {
			System.out.println(list);
		}

	}

	public void calcular() {
		System.out.println();
		System.out.println();
		System.out.println("Implementando una interfaz y sobreescribiendo su funcionalidad");
		Operacion operacion = new Operacion() {

			@Override
			public double promedio(double n1, double n2) {
				return (n1 + n2) / 2;
			}

		};
		System.out.println(operacion.promedio(2, 3));
		
		System.out.println();
		System.out.println();
		System.out.println("Implementando una interfaz con lambda");
		//En lugar de hacer new Operacion simplemente se le pasa la expresi{on lambda para crear la implementación
		Operacion operacion2 = (double x,double y) -> (x+y)/2;
		System.out.println(operacion2.promedio(2, 3));
	}

	public static void main(String[] args) {
		LambdaApp lambdaApp = new LambdaApp();
		lambdaApp.ordenar();
		lambdaApp.calcular();
	}

}
