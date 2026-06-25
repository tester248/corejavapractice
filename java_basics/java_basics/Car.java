package java_basics;

public class Car {
	private String model;
	private String[] features;
	
	public Car(String model, String...features) {
		super();
		this.model = model;
		this.features = features;
	}
	
	public void specs()
	{
		System.out.println("Feature of " + model);
		for(String f : features)
			System.out.println(f);
	}
	
	public static void main(String[] args) {
		
		Car baleno = new Car("Baleno", "Keyless", "ABS", "ADAS", "Cruise");
		baleno.specs();	
	}
}
