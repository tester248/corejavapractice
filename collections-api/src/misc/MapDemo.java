package misc;

import java.util.HashMap;

import sun.jvm.hotspot.gc.parallel.PSYoungGen;

public class MapDemo {

	public static void main(String[] args) {
		
		HashMap<String, String>  map = new HashMap<>();
		map.put("scott", "tiger");
		map.put("jack", "jill");
		map.put("polo", "lili");
		map.put("jack", "rose");
		
		System.out.println("Scott:" + map.get("scott"));
		System.out.println("Polo:" + map.get("polo"));
		System.out.println("Jack:" + map.get("jack"));
		
		// Print all keys and values wihtout manually feeding keys
		
		for (String key: map.keySet())
			System.out.println(key + ": " + map.get(key));
		
		map.forEach((key,value) -> System.out.println(key + ": " + value));
	}

}
