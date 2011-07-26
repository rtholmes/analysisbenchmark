package ca.uwaterloo.cs.se.bench.simple;

import java.util.HashSet;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

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
		Vector v = FieldClass.staticFieldVector;
	}

	@Test
	public void testWriteFieldSAtaticVector() {
		FieldClass.staticFieldVector = new Vector();
	}

	@Test
	public void testReadStaticVectorInit() {
		Vector v = FieldClass.staticFieldVectorInit;
	}

	@Test
	public void testWriteFieldSAtaticVectorInit() {
		FieldClass.staticFieldVectorInit = new Vector();
	}

	@Test
	public void testReadStaticBlockHashSetInit() {
		HashSet h = FieldClass.staticBlockHashSetInit;
	}

	@Test
	public void testWriteStaticBlockHashSetInit() {
		FieldClass.staticBlockHashSetInit = new HashSet();
	}

}
