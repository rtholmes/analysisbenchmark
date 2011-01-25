package ca.uwaterloo.cs.se.bench.simple;

import java.util.Vector;

public class InhClassA extends InhAbstractClass {

	@Override
	public void interfaceMethodB() {
		interfaceMethodC();
	}

	@Override
	public void interfaceMethodA() {
		Vector v = new Vector();
	}

	@Override
	public void abstractMethodA() {
		String s = new String("str");
	}

}
