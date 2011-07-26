package ca.uwaterloo.cs.se.bench.simple;

import org.junit.Test;

public class ReflectionClassTest {
	@Test
	public void testInstantaiteString() {
		ReflectionClass rc = new ReflectionClass();
		rc.instantiateString();
	}

	@Test
	public void testVector() {
		ReflectionClass rc = new ReflectionClass();
		rc.callVectorAddAndSize();
	}

}
