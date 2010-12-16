package ca.uwaterloo.cs.se.bench.model;

import java.util.Collection;
import java.util.Vector;

public class ClassElement extends AnnotatableElement {
	public ClassElement(String id, boolean isInterface, boolean isClass) {
		_id = id;
		_isInterface = isInterface;
		_isClass = isClass;
	}

	String _id;
	String _package;

	Collection<ClassElement> _extends = new Vector<ClassElement>();
	Collection<ClassElement> _implements = new Vector<ClassElement>();

	Collection<FieldElement> _fields = new Vector<FieldElement>();
	Collection<MethodElement> _methods = new Vector<MethodElement>();

	boolean _isInterface = false;
	boolean _isAbstract = false;
	boolean _isClass = true;

	public void setMethods(Collection<MethodElement> methods) {
		_methods = methods;
	}

	public void setFields(Collection<FieldElement> fields) {
		_fields = fields;
	}


}
