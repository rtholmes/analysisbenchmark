package ca.uwaterloo.cs.se.bench.simple;

import java.util.HashSet;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import ca.uwaterloo.cs.se.bench.simple.AnonClass;

public class FieldClassTest {

	private FieldClass _fc;

	@Before
	public void setup() {
		_fc = new FieldClass();
	}

	@Test
	public void testReadFieldString() {
		String s = _fc.fieldString;
	}

	@Test
	public void testWriteFieldString() {
		_fc.fieldString = "writeFieldString";
	}

	@Test
	public void testReadFieldStringValue() {
		String s = _fc.fieldStringValue;
	}

	@Test
	public void testWriteFieldStringValue() {
		_fc.fieldStringValue = "writeFieldString";
	}

	@Test
	public void testReadFieldStringInit() {
		String s = _fc.fieldStringInit;
	}

	@Test
	public void testWriteFieldStringInit() {
		_fc.fieldStringInit = "writeFieldString";
	}

	@Test
	public void testReadStaticVector() {
		Vector v = _fc.staticFieldVector;
	}

	@Test
	public void testWriteFieldSAtaticVector() {
		_fc.staticFieldVector = new Vector();
	}

	@Test
	public void testReadStaticVectorInit() {
		Vector v = _fc.staticFieldVectorInit;
	}

	@Test
	public void testWriteFieldSAtaticVectorInit() {
		_fc.staticFieldVectorInit = new Vector();
	}

	@Test
	public void testReadStaticBlockHashSetInit() {
		HashSet h = _fc.staticBlockHashSetInit;
	}

	@Test
	public void testWriteStaticBlockHashSetInit() {
		_fc.staticBlockHashSetInit = new HashSet();
	}

}
