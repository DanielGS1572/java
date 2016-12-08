package Capitulo6;

import java.util.Scanner;

public class BuscadorMaximo {
	public void ingresaDatos() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce los 3 valores");

		double primero = entrada.nextDouble();
		double segundo = entrada.nextDouble();
		double tercero = entrada.nextDouble();

		double resultado = obtieneMaximo(primero, segundo, tercero);
		System.out.println("El resultado máximo es: " + resultado);
	}

	public double obtieneMaximo(double uno, double dos, double tres) {
		double numeroMaximo = uno;

		if (numeroMaximo < dos)
			return dos;
		if(numeroMaximo < tres)
			return tres;
		
		return numeroMaximo;
	}
}
