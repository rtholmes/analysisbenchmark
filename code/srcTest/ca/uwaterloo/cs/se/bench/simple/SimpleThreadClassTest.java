package ca.uwaterloo.cs.se.bench.simple;

import org.junit.Test;

public class SimpleThreadClassTest {

	@Test
	public void testThreads() {
		SimpleThreadClass stc = new SimpleThreadClass();
		stc.run(10000);
	}
}
