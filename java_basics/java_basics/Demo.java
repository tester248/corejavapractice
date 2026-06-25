package java_basics;

public class Demo<T> {
	private T data;

	public Demo(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public static void main(String[] args) {
		Demo<String> d1 = new Demo<String>("Hello");
		System.out.println(d1.getData());
	}
}


public class SubDemo<T, P> extends Demo<T>
{
	private P temp;

	public SubDemo(T data, P temp) {
		super(data);
		this.temp = temp;
	}

	public P getTemp() {
		return temp;
	}

	public void setTemp(P temp) {
		this.temp = temp;
	}
	
	public static void main(String[] args) {
		SubDemo<String, Integer> sd = new SubDemo<String, Integer>("Mona", 99);
		System.out.println(sd.getData() + "\t" + sd.getTemp());
	}
	
}
