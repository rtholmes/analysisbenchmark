package ca.uwaterloo.cs.se.bench.model;

import java.util.Vector;

public class FieldElement extends AnnotatableElement {
	public FieldElement(String id, boolean isExternal, ClassElement type) {
		_id = id;
		_type = type;
		_isExternal = isExternal;
	}

	public FieldElement(String id, boolean isExternal) {
		_id = id;
		_isExternal = isExternal;
	}

	ClassElement _type = null;

	// TODO: field generics
	Vector<ClassElement> _generics = new Vector<ClassElement>();

	// TODO: field arrays
	boolean _isArray = false;

	// TODO: field multidimensional ararys
	int _arrayDimensions = -1;

	public ClassElement getType() {
		return _type;
	}
}