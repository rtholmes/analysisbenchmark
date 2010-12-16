package ca.uwaterloo.cs.se.bench.model;

import java.util.Vector;

public class MethodReturnElement {

	public MethodReturnElement(String type) {
		_type = type;
	}

	String _type;
	// ClassElement _type;

	// TODO: generic returns
	Vector<ClassElement> _generics = new Vector<ClassElement>();

	// TODO: array returns
	boolean _isArray = false;

	// TODO: multidimensional array returns
	int _arrayDimensions = -1;
}
