package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SecondStreamDemo {
	
	public static void main(String[] args) {
		
		List<String> basket = Arrays.asList("Cherry", "Mango", 
				"Papaya", "Guava", "Banana");
		
		basket.stream().forEach(System.out::println);
		
		System.out.println("--- Filtered (starts with M or P) ---");
		basket.stream()
			.filter(fruit -> fruit.startsWith("M") || fruit.startsWith("P"))
			.forEach(System.out::println);
		
		System.out.println("--- Sorted ---");
		basket.stream()
			.sorted()
			.forEach(System.out::println);
		
		System.out.println("--- Uppercase ---");
		basket.stream()
			.map(String::toUpperCase)
			.forEach(System.out::println);
		
		System.out.println("--- Collected to List ---");
		List<String> upperFruits = basket.stream()
			.map(String::toUpperCase)
			.collect(Collectors.toList());
		System.out.println(upperFruits);
		
		System.out.println("--- Count fruits with length > 5 ---");
		long count = basket.stream()
			.filter(fruit -> fruit.length() > 5)
			.count();
		System.out.println(count);
		
		System.out.println("--- Any fruit starts with B ---");
		boolean anyStartsWithB = basket.stream()
			.anyMatch(fruit -> fruit.startsWith("B"));
		System.out.println(anyStartsWithB);
		
		System.out.println("--- All fruits length > 3 ---");
		boolean allLengthGT3 = basket.stream()
			.allMatch(fruit -> fruit.length() > 3);
		System.out.println(allLengthGT3);
		
		System.out.println("--- First fruit starting with P ---");
		basket.stream()
			.filter(fruit -> fruit.startsWith("P"))
			.findFirst()
			.ifPresent(System.out::println);
	}
}