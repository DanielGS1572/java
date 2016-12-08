package Capitulo3.Colecciones8;

import java.util.ArrayList;

public class ArrayLst {

	public static void main(String[] args) {
		ArrayList lista = new ArrayList();
		lista.add(1); // El arrayList no acepta tipos primitivos como int, por
						// lo que se usa la clase envoltorio Integer, el poder
						// pasarle como parametro un tipo de dato int y
						// convertirlo a Integer sin tener que declararlo con
						// new Integer se llama autoboxing
		
		lista.add(new Integer(2));
		// lista.add(char 's');
		lista.add("s");
		lista.add(3);
		lista.add(4);
		lista.add(5);
		lista.add(6);
		lista.add(7);
		
		int a = (int)lista.get(1);	//a esto se le llama unboxing convertir un objeto Object a un Integer
		int b = (Integer)lista.get(1);
		
		System.out.println("a: " + a );
		System.out.println("b: " + b );
		System.out.println();
		
		System.out.println(lista.indexOf("s"));
		System.out.println(lista.size());
		lista.remove(2);	//remueve la s
		
		System.out.println();
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}
		
		System.out.println();
		for(Object obj:lista){
			System.out.println((Integer)obj); //a obj se le puede hacer un casteo de cierto tipo de dato
		}

		
	}
}
