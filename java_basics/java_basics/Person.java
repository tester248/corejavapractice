package java_basics;

public class Person implements Cloneable {
	private String name; 
	private int age;
	
	public Person()
	{
		this("Anonymous", -1);
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void print()
	{
		System.out.println("Name: " + name + ", Age: " + age);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person)
		{
			Person p = (Person) obj; //downcasting
			if(this.age == p.age && name.equals(p.name))
				return true;
		}
		return false;
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		Person p1 = new Person("Polo", 21);
		p1.print();
		Person p2 = new Person("Polo", 21);
		p2.print();
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		System.out.println(p1); //implicitly calls toString() on the object 
		System.out.println(p1.equals(p2)); //compares hashcode so false until equals method is overriden with comparison logic
		
		Person pc = (Person) p1.clone();
		System.out.println(pc);
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
