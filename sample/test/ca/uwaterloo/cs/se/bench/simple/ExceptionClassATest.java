package ca.uwaterloo.cs.se.bench.simple;

import org.junit.Test;

/**
 * 
 * @author rtholmes
 * 
 */
public class ExceptionClassATest {
	@Test
	public void callA() {
		ExceptionClassA eca = new ExceptionClassA();
		eca.a1();
	}

	@Test
	public void callB() {
		ExceptionClassA eca = new ExceptionClassA();
		eca.b1();
	}

	@Test
	public void callC() {
		ExceptionClassA eca = new ExceptionClassA();
		eca.c1();
	}
}
