package streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapStreamDemo {

	public static void main(String[] args) {
		Map<String, String> people = new HashMap<>();
		people.put("Polo", "Pune");
		people.put("Mili", "Mumbai");
		people.put("Deny", "Delhi");
		
		people.values().stream().forEach(System.out::println);
		
		List<String> cities = people.values().stream()
			.map(String::toUpperCase)
			.sorted()
			.collect(Collectors.toList());
		
		cities.forEach(System.out::println);
		
		Map<String, List<String>> contacts = new HashMap<>();
		contacts.put("Frudo", Arrays.asList("1212-3434", "5656-7878"));
		contacts.put("Sean", Arrays.asList("1212-3434", "5656-7878", "8989-5050"));
		contacts.put("Ben", Arrays.asList("1212-3434", "5656-7878", "2424-2242"));
		
		contacts.values().stream()
			.flatMap(Collection::stream)
			.forEach(System.out::println);
		
		// Print all 
		contacts.values().stream()
			.flatMap(Collection::stream)
			.filter(phone -> phone.contains("8"))
			.forEach(System.out::println);
		
		System.out.println("--- Distinct phone numbers ---");
		contacts.values().stream()
			.flatMap(Collection::stream)
			.distinct()
			.forEach(System.out::println);
		
		System.out.println("--- Name and phone count ---");
		contacts.entrySet().stream()
			.forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue().size() + " numbers"));
		
		System.out.println("--- Map to Map: name -> phone count ---");
		Map<String, Integer> phoneCount = contacts.entrySet().stream()
			.collect(Collectors.toMap(
				Map.Entry::getKey,
				entry -> entry.getValue().size()
			));
		System.out.println(phoneCount);
		
		System.out.println("--- People grouped by city ---");
		Map<String, List<String>> byCity = people.entrySet().stream()
			.collect(Collectors.groupingBy(
				Map.Entry::getValue,
				Collectors.mapping(Map.Entry::getKey, Collectors.toList())
			));
		System.out.println(byCity);
	}
}