package ca.uwaterloo.cs.se.bench.model;

import java.util.Vector;

public abstract class TypeReferenceElement {

	// TODO: multidimensional array returns
	private int _arrayDimensions = -1;

	// TODO: generic returns
	private Vector<ClassElement> _generics = new Vector<ClassElement>();

	// TODO: array returns
	private boolean _isArray = false;

	private final ClassElement _type;

	public TypeReferenceElement(ClassElement type) {
		_type = type;
	}

	public ClassElement getType() {
		return _type;
	}
}
