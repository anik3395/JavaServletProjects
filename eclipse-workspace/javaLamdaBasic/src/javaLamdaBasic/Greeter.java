package javaLamdaBasic;

public class Greeter {
	
	public static void main (String[] args) {
		Greeting myLambdaFunction = () -> {
			System.out.print("Hello World");//Lamda Expression
		};
		
		Greeting greeting = new Greeting() {
			public void performe() {
				System.out.print("Hello World");//general Object calling in inner class.
			}
		};
		
		myLambdaFunction.performe();
		greeting.performe();
	}
	
	public interface MyLamda{
		void foo();
	}

}
