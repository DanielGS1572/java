package Collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class VariousMaps {

	public static void main(String[] args) {
		
//Aqui en la declaración de la variable se pone como Map para que los tres tipos se puedan manejar de forma general con la interfaz
		Map<Integer,String> hashMap = new HashMap<Integer,String>();
		Map<Integer,String> linkedMap = new LinkedHashMap<Integer,String>();
		Map<Integer,String> treeMap = new TreeMap<Integer,String>();
		
		
		System.out.println("hashmap");	//No hay garantia que los deje ordenados
		testMap(hashMap);
		System.out.println("\nlinkedmap");	//los deja como se van cargando
		testMap(linkedMap);
		System.out.println("\ntreedmap");	//los ordena por la llave
		testMap(treeMap);
	}
	
// Los 3 tipos de Mapas implementan de la interfaz Map
	public static void testMap(Map<Integer,String> map){
		map.put(8, "8");
		map.put(3, "3");
		map.put(15, "15");
		map.put(6, "6");
		map.put(-1, "-1");
		map.put(0, "0");
		map.put(200, "200");
		//keySet regresa un collection que le llaman set
		for(Integer i:map.keySet()){
			System.out.println(i + " : " + map.get(i));
		}
	}
}
