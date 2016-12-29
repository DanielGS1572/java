package JavaBasics.Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Collections1 {
// Collections se refiere a la estructura de datos
	/**
	 * Las interfaces mas populares son:
	 * 	- List
	 * 		- ArrayList
	 * 			- Se acceden a través de un indice
	 * 			- Puede crecer y encojerse
	 * 			- Acepta duplicados (por ejemplo hello, tiene doble ele)
	 * 			- No es synchronized.- manda error de concurrencia (concurrent modification exception). Si se quieres agregar y remover por ejemplo
	 * 			- Instrucciones:
	 * 				- add
	 * 				- remove(Object|index) --> no remueve todos los mismos objetos sino el primero
	 * 				- isEmpty()
	 * 				- get(index)
	 * 				- contains(Object o) 
	 * 			- La desventaja es que si se quiere agregar un elemento en medio del arreglo se debe de recorrer todo para insertarlo (shifting around)
	 * 		- LinkedList
	 * 			- No tienen indice.- (pero si se le puede indicar que remueva el elemento n) trabaja con referencias con el siguiente elemento del arreglo y unicamente apunta al primer y ultimo elemento 
	 * 			- Instrucciones:
	 * 				- next (a partir del primer elemento, pues no tiene sistema de indices). Se usa instanciando un Iterator y con el objeto preguntar .hasNext --> O puede usarse un for each (si se quiere remover elementos mientras se esta iterando el for each puede dar problemas, por lo que se puede usar el iterator. El for-each es nada mas para conocer que tiene)
	 * 				- no hay instruccion para ir hacia atras
	 * 				- push --> agrega un elemento al final de la lista
	 * 				- pop --> obtiene del principio de la lista
	 * 			- Es mas practico porque funciona a través de un apuntador y no tiene que recorrer "casillas" --> big O notation (mide la complejidad de la funcion que se quiera implementar)
	 * 			- FIFO (Firt In First Out) [Implementa la interfaz que se llama Queue, que es una cola de espera, el primero en formarse es el primero en salir]
	 * 		
	 * 	- Map
	 * 		- HashMap
	 * 			- Se usa put(key,value)
	 * 			- Se usa get(key) para obtener el valor de cierta llave
	 * 			- keySet regresa como String todas las llaves
	 * 			- si se repite la llave se sobre escribe el value
	 * 			- Para obtener la lista completa de llave valor se usa for(Map.Entry<String,List<String>> entry: MapaAIterar.entrySet()) --> entry.getKey(), entry.getValue()  
	 * 	- Set
	 * 		- Es como una lista pero no hay duplicados
	 * 		- No tienen indices(no tiene get(n) por ejemplo) -- PARA remover no se le pasa el indice como linkedlist si no que se le pasa el objeto
	 * 
	 * 
	 * 		- HashSet
	 * 			- Hash se refiere a que el objeto que se le pase lo convertira en una dirección unica en memoria, pero es posible que exista colisión y guarde dos numero en un arreglo [10,10131] --> Hashing algorithm
	 * 			- El orden que guardan los hace con respecto a la direccion de memoria
	 * 			- Es eficiente en guardar y extraer información
	 * 		- TreeSet
	 * 			- Mantiene el orden (por lo que internamente hace un sorting)
	 * 			- Para obtener el orden descendente en el TreeSet debe hacerse con un iterator, se debe hacer un casteo a TreeSet
	 * 		- LinkedHashSet
	 * 			- Guarda el orden conforme se vayan guardando pero no es tan popular
	 * (la lista anterior se refiere a que son interfaces y son las más comunes)
	 * (una interfaz no se puede instanciar por lo que para eso se usan el 
	 * ArrayList y el LinkedList)
	 */
	public static void main(String[] args) {
		// ################################ ArrayList ###########################
		// List es la interfaz
		// ArrayList es la implementación de la interfaz
		List<String> myArrayList = new ArrayList<String>();
		System.out.println("Is my list empty? " + myArrayList.isEmpty());
		System.out.println("Let's put some stuff in!");
		
		myArrayList.add("H");
		myArrayList.add("E");
		myArrayList.add("L");
		myArrayList.add("L");
		myArrayList.add("O");
		
		System.out.println("Is my list empty? " + myArrayList.isEmpty());
		myArrayList.add("!");
		
		System.out.println("What's in my array? " + myArrayList.toString());
		System.out.println("Now let's modify the array ");
		
		myArrayList.remove("L");
		System.out.println("What's in my array? " + myArrayList.toString() + "\n\n");
		
		// ################################ LinkedList ###########################
		List<String> myLinkedList = new LinkedList<String>();
		myLinkedList.add("H");
		myLinkedList.add("E");
		myLinkedList.add("L");
		myLinkedList.add("L");
		myLinkedList.add("O");
		myLinkedList.add("!");
		
		System.out.println("What's in my LinkedList " + myLinkedList.toString());
		
		System.out.println("Let's remove " + myLinkedList.remove(3));
		System.out.println("What's in my LinkedList " + myLinkedList.toString());

		Iterator<String> itr = myLinkedList.iterator(); //Lo que regresa iterator es un objeto de tipo Iterator por lo que se debe de declarar
		while(itr.hasNext()){
			System.out.print(itr.next());
		}
		
		System.out.println("\n\n");
		
		for(String letter:myLinkedList){
			System.out.print(letter);
		}
		System.out.println("\n\nSet");
	// ################################ SET ###########################

//			Set<Integer> myHashSet = new HashSet<Integer>();
			Set<Integer> myHashSet = new TreeSet<Integer>();
//			Set<Integer> myHashSet = new LinkedHashSet<Integer>();
				
				myHashSet.add(30);
				myHashSet.add(15);
				myHashSet.add(20);
				myHashSet.add(5);
				myHashSet.add(25);
				myHashSet.add(10);
				
				myHashSet.remove(15);
				
				Iterator<Integer> itr2 = ((TreeSet)myHashSet).descendingIterator();
				
				while(itr2.hasNext()){
					System.out.println(itr2.next());
				}
				
//				for(Integer i:myHashSet){
//					System.out.println(i + ", ");
//				}
	System.out.println("\n\nMap\n");
	// ################################ Map ###########################
	Map<String,List<String>> myMap = new HashMap<String,List<String>>();
		List<String> regionList = new ArrayList<String>();
		regionList.add("NY");
		regionList.add("CA");
		myMap.put("USA", regionList);
		
	
		List<String> regionList2 = new ArrayList<String>();
		regionList2.add("ON");
		regionList2.add("AB");
		myMap.put("Canada", regionList2);
		
		Collection<List<String>> values = myMap.values();
		for(List<String> lista: values){
			for(String regiones:lista){
				System.out.println(regiones);
			}
		}
//		for(String key:myMap.values()){
//			System.out.println(key);
//		}
		System.out.println("\nObtener llave valor");
		//Una forma de obtener la llave y valor es:
		for(Map.Entry<String,List<String>> entry: myMap.entrySet()){
			System.out.println("" + entry.getKey() + "," + entry.getValue());
		}
		
		//Have a look at these methods and how they work
//		myMap.remove();
//		myMap.containsKey();
//		myMap.containsValue();
	}

}
