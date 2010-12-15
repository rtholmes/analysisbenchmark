package ca.uwaterloo.cs.se.bench.model;

import java.util.Vector;

public class MethodReturnElement {
	ClassElement _type;
	Vector<ClassElement> _generics = new Vector<ClassElement>();
	boolean _isArray = false;
	int _arrayDimensions = -1;
}
