package ca.uwaterloo.cs.se.bench.simple;

import org.junit.Test;

import ca.uwaterloo.cs.se.bench.simple.AnonClass;

public class AnonClassTest {
	@Test
	public void execSimple() {
		AnonClass ac = new AnonClass();
		ac.simpleAnonymous();
	}

	@Test
	public void execSimpleGeneric() {
		AnonClass ac = new AnonClass();
		ac.genericAnonymous();
	}
}
