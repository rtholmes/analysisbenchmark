package ca.uwaterloo.cs.se.bench.simple;

import org.junit.Test;

import ca.uwaterloo.cs.se.bench.simple.NestedClass;
import ca.uwaterloo.cs.se.bench.simple.NestedClass.InnerClass;
import ca.uwaterloo.cs.se.bench.simple.NestedClass.InnerClass.InnerInnerClass;

public class NestedClassTest {
	@Test
	public void createNested() {
		NestedClass nc = new NestedClass();
		nc.nestedMethodA();
	}

	@Test
	public void createInner() {
		NestedClass nc = new NestedClass();
		InnerClass ic = nc.new InnerClass();
		ic.innerMethodB();

	}

	@Test
	public void createInnerInner() {
		NestedClass nc = new NestedClass();
		InnerClass ic = nc.new InnerClass();
		InnerInnerClass iic = ic.new InnerInnerClass();
		iic.innerInnerMethodC();
	}
}
