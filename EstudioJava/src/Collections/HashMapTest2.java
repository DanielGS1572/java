package Collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest2 {
	public static void main(String[] args){
		HashMap<String,Integer> map= new HashMap<String,Integer>();
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		System.out.println("keyset" + map.keySet());
		for(String key:map.keySet()){
			System.out.println(key + ":" + map.get(key));
		}
	}
}
