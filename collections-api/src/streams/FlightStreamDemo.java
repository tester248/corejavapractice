package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlightStreamDemo {

	public static void main(String[] args) {
		try (Stream<String> lines = Files.lines(Paths.get("src/streams/flight.txt"))) {
			List<Flight> flights = lines.map(line -> {
				String[] record = line.split(",");
				return new Flight(Integer.parseInt(record[0]), record[1], record[2], record[3]);
			}).collect(Collectors.toList());
			
			flights.forEach(System.out::println);
		
			// Print details of flight no 123
			System.out.println("\n--- Flight no 123 ---");
			flights.stream()
				.filter(f -> f.getFlightNo() == 123)
				.findFirst()
				.ifPresentOrElse(System.out::println, () -> System.out.println("Not found"));
			
			// Print all flights by Jet carrier (AirIndia)
			System.out.println("\n--- Flights by AirIndia ---");
			flights.stream()
				.filter(f -> f.getCarrier().equalsIgnoreCase("AirIndia"))
				.forEach(System.out::println);
			
			// Print flight going pune to delhi (case insensitive)
			System.out.println("\n--- Flights Pune to Delhi ---");
			flights.stream()
				.filter(f -> f.getFrom().equalsIgnoreCase("Pune") && f.getTo().equalsIgnoreCase("Delhi"))
				.forEach(System.out::println);
			
			// Remove a flight no 920
			System.out.println("\n--- After removing flight 920 ---");
			List<Flight> filtered = flights.stream()
				.filter(f -> f.getFlightNo() != 920)
				.collect(Collectors.toList());
			filtered.forEach(System.out::println);
			
			// Additional: Count flights by carrier
			System.out.println("\n--- Flight count by carrier ---");
			flights.stream()
				.collect(Collectors.groupingBy(Flight::getCarrier, Collectors.counting()))
				.forEach((carrier, count) -> System.out.println(carrier + ": " + count));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}