package Collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		map.put(5, "Five");
		map.put(4, "Four");
		map.put(3, "Three");
		map.put(8, "Eight");
		
		map.put(8, "Hello");
		
		System.out.println(map.get(2));
		System.out.println(map.get(5));
		System.out.println(map.get(8));
		System.out.println("");
		map.remove(4);
//		Para iterar un hashmap
//		 No mantiene el orden, cuando se itere a traves de todos los elementos es posible que esten movidos. En un principio queda ordenado
//		pero no es garantía
		for(Map.Entry<Integer, String> hm: map.entrySet()){
			System.out.println("key: " + hm.getKey() + " Values: " + hm.getValue());;
		}
	}

}
