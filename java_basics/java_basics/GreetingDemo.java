package java_basics;

interface Greeting{
	void sayHello();
}

public class GreetingDemo 
{
	public class GreetingInnerImpl implements Greeting
	{

		@Override
		public void sayHello() {
			System.out.println("Greeting Inner Impl");
		}
		
	}
	
	public void anotherDemo()
	{
		class GreetingNestedImpl implements Greeting {

			@Override
			public void sayHello() {
				System.out.println("Greeting Nested Impl");
			}
			
		};
		new GreetingNestedImpl().sayHello();
	}
	
	public static void main(String[] args) {
		GreetingDemo demo = new GreetingDemo();
		Greeting g1 = demo.new GreetingInnerImpl();
		g1.sayHello();
		demo.anotherDemo();
		
		//anonymous class
		Greeting g = new Greeting() {
			@Override
			public void sayHello() {
				System.out.println("Greeting from Anonymous inner class");
			}
		};
		g.sayHello();
		
		Greeting greet = () -> System.out.println("Geeting from Lambda");
		greet.sayHello();
	}
}
