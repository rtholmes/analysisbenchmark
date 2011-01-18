package ca.uwaterloo.cs.se.bench.simple;

//This is my first interface
interface First_interface {

}

// This is my second interface
interface Second_interface {
}

// This will be the first super class
class First_Parent {

	public void a() {
	}

}

// This will be the child class
class First_child extends First_Parent implements First_interface, Second_interface {
	public void b() {
		a();
	}

	// Need main to run
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

}
