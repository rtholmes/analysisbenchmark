package ca.uwaterloo.cs.se.bench.model;

import java.util.Vector;

public class FieldElement extends AnnotatableElement {
	// TODO: field multidimensional ararys
	private int _arrayDimensions = -1;

	// TODO: field generics
	private Vector<ClassElement> _generics = new Vector<ClassElement>();

	// TODO: field arrays
	private boolean _isArray = false;

	private ClassElement _type = null;

	public FieldElement(String id, boolean isExternal) {
		_id = id;
		_isExternal = isExternal;
	}

	public FieldElement(String id, boolean isExternal, ClassElement type) {
		_id = id;
		_type = type;
		_isExternal = isExternal;
	}

	public ClassElement getType() {
		return _type;
	}
}
