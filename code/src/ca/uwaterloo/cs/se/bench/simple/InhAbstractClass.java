package ca.uwaterloo.cs.se.bench.simple;

public abstract class InhAbstractClass implements InhInterface {

	public abstract void abstractMethodA();

	public void abstractMethodB() {

	}

	@Override
	public abstract void interfaceMethodA();

	@Override
	public void interfaceMethodC() {
		// default implementation
	}
}
