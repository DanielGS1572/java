package Streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StreamsApp {

	private List<String> lista;
	private List<String> numeros;

	public StreamsApp() {
		lista = new ArrayList<>();
		lista.add("Mito");
		lista.add("Code");
		lista.add("Jaime");
		lista.add("MitoCode");

		numeros = new ArrayList<>();
		numeros.add("1");
		numeros.add("2");
	}

	public void filtrar() {
		lista.stream().filter(x -> x.startsWith("M"))
				.forEach(System.out::println/* y -> System.out.println(y) */);
	}

	public void ordenar() {
		// en lugar de usar:
		/*
		 * Collections.sort(lista,(x,y)-> y.compareTo(x));
		 * lista.forEach(System.out::println);
		 */

		// lista.stream().sorted().forEach(System.out::println); //orden
		// ascendente
		lista.stream().sorted((x, y) -> y.compareTo(x)).forEach(System.out::println); // orden
																						// descendente
	}

	public void transformar() {
		// Map es una funcion de transformación
		lista.stream().map(String::toUpperCase).forEach(System.out::println);
		// Se hace el casteo de cada elemento de tipo String y se le suma 1
		numeros.stream().map(x -> Integer.parseInt(x) + 1).forEach(System.out::println);
	}

	public void limitar() {
		lista.stream().limit(2).forEach(System.out::println);
		;
	}

	public void contar() {
		System.out.println(lista.stream().count());
	}

	public static void main(String[] args) {
		StreamsApp app = new StreamsApp();
		// app.filtrar();
		// app.ordenar();
		// app.transformar();
		app.limitar();
		app.contar();
	}

}
