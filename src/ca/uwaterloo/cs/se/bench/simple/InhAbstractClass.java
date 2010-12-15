package ca.uwaterloo.cs.se.bench.simple;

public abstract class InhAbstractClass implements InhInterface {

	@Override
	public abstract void interfaceMethodA();

	@Override
	public void interfaceMethodC() {
		// default implementation
	}
	
	public abstract void abstractMethodA();
	
	public void abstractMethodB() {
		
	}
}
