package Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lists {

	public static void main(String[] args) {
		// Implementaciones de la lista Interface
		//ArrayList, LinkedList, Vector, Stack
		
		//Vector ya no es usado
		
		// La desventaja de arraylist es que se puede desperdiciar mucho espacio, éste se inicializa de cierto tamaño y si se extiende
		// del tamaño definido, tiene que copiar todos los elementos al nuevo arraylist dimensionado
		
		// Lo anterior no sucede con LinkedLists, es lento para acceder elementos pues se tiene que encontrar el primer elemento y 
		// se va por referencias
		
		
//Arraylists es eficiente para agregar elementos al final
//LinkedListe es eficiente para agregar elementos al principio en cualquier punto del arreglo
		
//		ArrayList implementa la interfaz de List
		List myList = new ArrayList();		//Genera objetos de tipo Object, por lo que se tendra que hacer cast
		
		myList.add("Objeto 1");
		myList.add("Objeto 2");
		myList.add("Objeto 3");
		myList.add("Objeto 4");
		System.out.println("Muestra:");
		for(int i=0;i<myList.size();i++){
			System.out.println(myList.get(i));
		}
		
		myList.remove(1);
		System.out.println("\nEliminando:");
		for(int i=0;i<myList.size();i++){
			System.out.println(myList.get(i));
		}
		
		//Hay 3 Formas de Iterar, con iterator
		Iterator it = myList.iterator(); //<-- INTERFAZ
		while(it.hasNext()){
		Object next = it.next();	//next es de tipo Object porque la lista puede aceptar cualquier tipo de Objetos (clase cosmica)
		System.out.println("Iterator: " + next);
		}
		
		for(Object l:myList){			//igual aqui l es de tipo object
			System.out.println("For: " + l);
		}
		
		List<String> list2 = new ArrayList<String>();
		
//		list2.add(new Integer(3));	<-- Esto no funcionaria porque solo acepta String
		list2.add("List1");
	}

}
