package Colecciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ColeccionApp {
	private List<String> lista;

	public void llenarLista() {
		lista = new ArrayList<>();
		lista.add("MitoCode");
		lista.add("Mito");
		lista.add("Code");
	}

	public void usarForEach() {
		// lista.forEach(x -> System.out.println(x)); //usa por default un
		// Consumer por lo que se debe implementar
		lista.forEach(System.out::println);
	}

	public void usarRemoveIf() {
		// Para poder borrar un elemento de un arreglo si se hace a traves de un
		// ciclo for mandará error por concurrencia
		// Por lo que se puede hacer uso de Iterator
//		Iterator<String> it = lista.iterator();
//		while(it.hasNext()){
//			if (it.next().equalsIgnoreCase("Mito")) {
//				it.remove();
//			}
//			
//		}
		
		lista.removeIf(x -> x.equalsIgnoreCase("Mito")); // hace uso de predicados para agregar, quitar etc
	}
	
	public void usarSort(){
		lista.sort((x,y) -> x.compareTo(y));
	}

	public static void main(String[] args) {
		ColeccionApp col = new ColeccionApp();
		col.llenarLista();
//		col.usarRemoveIf();
		col.usarSort();col.usarForEach();
		

	}

}
