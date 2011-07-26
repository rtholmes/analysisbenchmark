package ca.uwaterloo.cs.se.bench.simple;

//This is my first interface
interface FirstInterface {

}

// This is my second interface
interface SecondInterface {
}

// This will be the first super class
class FirstParent {

	public void a() {
		String s = new String();
	}

}

// This will be the child class
class FirstChild extends FirstParent implements FirstInterface, SecondInterface {
	public void b() {
		a();
	}

	// Need main to run
	public static void main(String[] args) {
		System.out.println("Hello World!");
		FirstChild fc = new FirstChild();
		fc.a();
	}

}
