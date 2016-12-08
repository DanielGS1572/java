package Collections;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Sets almacena elementos únicos, si se intenta agregar uno existente
		// no pasa nada, a diferencia de arraylist que lo repetiria

		// No guarda el orden y eventualmente pueden cambiar
		// Set<String> set = new HashSet<String>();

		// para Ordenarlos usar linkedhashset
		// Set<String> set = new LinkedHashSet<String>();

		// para tener un orden natural usar treeset
		Set<String> set = new TreeSet<String>();

		set.add("dog");
		set.add("cat");
		set.add("mouse");
		set.add("horse");

		set.add("mouse");

		System.out.println(set);

		// Para revisar si un elemento se encuentr dentro del set...
		System.out.println(set.contains("aa"));
		System.out.println(set.contains("dog"));
		System.out.println(set.isEmpty());
		// Sets esta optimizado para hacer esto

		// Intersection

		Set<String> set2 = new TreeSet<String>();

		set2.add("dog");
		set2.add("cat");
		set2.add("Otro1");
		set2.add("Otro2");
		
		//Para no destruir los datos se crea un nuevo set
		Set<String> in = new LinkedHashSet<String>(set); //Genera una copia de set en resultado
		in.retainAll(set2); // <-- Si imprimo esto regrasa si si hubo intersección
		System.out.println("intersección: " + in);
		
		
		Set<String> notIn = new LinkedHashSet<String>(set);
		notIn.removeAll(set2);	//<-- Left Join
		System.out.println("No intersección: " + notIn);
		
		Set<String> notIn2 = new LinkedHashSet<String>(set2);
		notIn2.removeAll(set);	//<-- Left Join
		System.out.println("No intersección2: " + notIn2);
	}

}
