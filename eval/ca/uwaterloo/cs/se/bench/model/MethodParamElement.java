package ca.uwaterloo.cs.se.bench.model;

import java.util.Vector;

public class MethodParamElement {
	public MethodParamElement(String id, String type, int order) {
		_id = id;
		_order = order;
	}

	String _id; // might not need this (e.g., param name)
	// ClassElement _type;
	String _type;

	// TODO: param as generic type
	Vector<ClassElement> _generics = new Vector<ClassElement>();
	int _order = -1;

	// TODO: param as array
	boolean _isArray = false;

	// TODO: param as multidimensional arrays
	int _arrayDimensions = -1;
}
