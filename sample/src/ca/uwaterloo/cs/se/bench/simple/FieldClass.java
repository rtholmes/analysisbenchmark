package ca.uwaterloo.cs.se.bench.simple;

import java.util.HashSet;
import java.util.Vector;

public class FieldClass {

	String fieldString;
	String fieldStringValue = "fieldStringValue";
	String fieldStringInit = new String("fieldStringInit");

	static Vector staticFieldVector;
	static Vector staticFieldVectorInit = new Vector();

	static HashSet staticBlockHashSetInit;
	static {
		staticBlockHashSetInit = new HashSet();
	}
}
