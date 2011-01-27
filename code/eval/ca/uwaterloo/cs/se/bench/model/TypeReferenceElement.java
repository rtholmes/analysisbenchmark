package ca.uwaterloo.cs.se.bench.model;

import java.util.Vector;

public abstract class TypeReferenceElement {

	public TypeReferenceElement(ClassElement type) {
		_type = type;
	}

	final ClassElement _type;

	// TODO: generic returns
	Vector<ClassElement> _generics = new Vector<ClassElement>();

	// TODO: array returns
	boolean _isArray = false;

	// TODO: multidimensional array returns
	int _arrayDimensions = -1;

	public ClassElement getType() {
		return _type;
	}
}
