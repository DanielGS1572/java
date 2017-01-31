package com.mitocode.java8.java8mito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaApp {

	public void ordernar() {
		List<String> lista = new ArrayList<>();
		lista.add("MitoCode");
		lista.add("Code");
		lista.add("Mito");

		// JDK < 1.
		// programación imperativa... es muy verboso

		// Collections.sort(lista, new Comparator<String>() {
		//
		// @Override
		// public int compare(String o1, String o2) {
		// return o1.compareTo(o2);
		// }
		// });
		//
		// for (String elemento : lista) { System.out.println(elemento); }

		// Lambda
		Collections.sort(lista, (String p1/* Parametro1 */,
				String p2/* Parametro2 */) /*
											 * Estos dos parametros es lo que
											 * recibe como argumento la clase
											 * anonima
											 */ -> p1
						.compareTo(p2) /* El compareTo no es de java 8 */);

		for (String elemento : lista) {
			System.out.println(elemento);
		}
	}

	public void calcular() {
		// una interfaz no se puede instanciar por lo que se debe de implementar
		//esto es un enfoque imperativo
//		Operacion operacion = new Operacion() {
//
//			@Override
//			public double calcularPromedio(double n1, double n2) {
//				// TODO Auto-generated method stub
//				return (n1 + n2) / 2;
//			}
//
//		};
//		System.out.println(operacion.calcularPromedio(2, 3));
		
		Operacion operacion = (x,y) -> (x+y)/2;
		System.out.println(operacion.calcularPromedio(2, 3));
	}

	public static void main(String[] args) {
		LambdaApp app = new LambdaApp();
		app.ordernar();
		app.calcular();
	}

}
