package ca.uwaterloo.cs.se.bench.model;

import java.util.Vector;

public class FieldElement extends AnnotatableElement {
	public FieldElement(String id, String type) {
		_id = id;
		_type = type;
	}

	String _id; // field name

	// ClassElement _type;
	String _type;

	// TODO: field generics
	Vector<ClassElement> _generics = new Vector<ClassElement>();

	// TODO: field arrays
	boolean _isArray = false;

	// TODO: field multidimensional ararys
	int _arrayDimensions = -1;

}
