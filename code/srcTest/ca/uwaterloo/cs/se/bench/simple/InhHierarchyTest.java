package ca.uwaterloo.cs.se.bench.simple;

import org.junit.Test;
import ca.uwaterloo.cs.se.bench.simple.InhInterface;
import ca.uwaterloo.cs.se.bench.simple.InhClassA;

/**
 * This isn't complete but is a sufficient start.
 * 
 * @author rtholmes
 * 
 */
public class InhHierarchyTest {
	@Test
	public void createADirect() {
		InhClassA ica = new InhClassA();
	}

	@Test
	public void createAInDirect() {
		InhInterface ica = new InhClassA();
	}

	@Test
	public void createAAbstract() {
		InhAbstractClass ica = new InhClassA();
	}

	@Test
	public void callInterfaceADirect() {
		InhClassA ica = new InhClassA();
		ica.interfaceMethodA();
	}

	@Test
	public void callInterfaceAInDirect() {
		InhInterface ica = new InhClassA();
		ica.interfaceMethodA();
	}

	@Test
	public void callInterfaceAAbstract() {
		InhAbstractClass ica = new InhClassA();
		ica.interfaceMethodA();
	}

	@Test
	public void callAbsADirect() {
		InhClassA ica = new InhClassA();
		ica.abstractMethodA();
	}

	@Test
	public void callAbsAInDirect() {
		InhAbstractClass ica = new InhClassA();
		ica.abstractMethodA();
	}

}
