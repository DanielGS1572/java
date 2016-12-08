package Capitulo3.Colecciones8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Hashtable;

public class HashtableGestionNombres {
	public static void main(String[] args) throws IOException {
		Hashtable nombres = new Hashtable();
		String opcion;

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		do {
			System.out.println("Elegir opción:\n");
			System.out.println("1. Añadir nombre");
			System.out.println("2. Eliminar nombre");
			System.out.println("3. Mostrar todos los nombres");
			System.out.println("4. Salir");
			System.out.println("5. Revisar por nombre");

			opcion = bf.readLine();

			switch (Integer.parseInt(opcion)) {
			case 1:
				String nom, dni;
				System.out.println("Introduce nombre:");
				nom = bf.readLine();
				System.out.println("DNI: ");
				dni = bf.readLine();
				almacenaNombre(nom, dni, nombres);
				break;
			case 2:
				String d;
				System.out.println("Introduzca dni: ");
				d = bf.readLine();
				eliminaNombre(d, nombres);
				break;
			case 3:
				mostrarTodos(nombres);
				break;
			case 5:
				System.out.println("Introduzca nombre a borrar: ");
				String nombre = bf.readLine();
				revisarPorNombre(nombre,nombres);
				break;
			}
		} while (!opcion.equals("4"));

	}

	static void revisarPorNombre(String nombre, Hashtable lista){
		if(lista.contains(nombre)){
			System.out.println("existe registro");			
		}
	}

	static void almacenaNombre(String n, String k, Hashtable lista) {
		if (!lista.containsKey(k)) {
			lista.put(k, n);
		}
	}

	static void eliminaNombre(String k, Hashtable lista) {
		if (lista.containsKey(k)) {
			lista.remove(k);
		}
	}

	static void mostrarTodos(Hashtable lista) {
		System.out.println("Los nombres son: ");
		Enumeration claves = lista.keys();
		while (claves.hasMoreElements()) {
			String k = (String) claves.nextElement(); // se va barriendo a
														// través de la clave
			System.out.println(k + " -- " + lista.get(k));
		}
	}
}
