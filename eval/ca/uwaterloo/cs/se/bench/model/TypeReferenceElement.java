package ca.uwaterloo.cs.se.bench.model;

import java.util.Vector;

public class TypeReferenceElement {

	public TypeReferenceElement(ClassElement type) {
		_type = type;
	}

	ClassElement _type;
	// ClassElement _type;

	// TODO: generic returns
	Vector<ClassElement> _generics = new Vector<ClassElement>();

	// TODO: array returns
	boolean _isArray = false;

	// TODO: multidimensional array returns
	int _arrayDimensions = -1;

	public boolean equals(Object o) {
		if (o != null && o instanceof TypeReferenceElement) {
			return ((TypeReferenceElement) o).getType().equals(getType());
		}
		return false;
	}

	public ClassElement getType() {
		return _type;
	}
}
