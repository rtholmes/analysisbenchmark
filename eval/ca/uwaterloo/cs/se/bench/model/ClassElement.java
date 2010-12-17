package ca.uwaterloo.cs.se.bench.model;

import java.util.Collection;
import java.util.Vector;

public class ClassElement extends AnnotatableElement {
	public ClassElement(String id, boolean isInterface, boolean isClass, boolean isAbstract) {
		_id = id;
		_isInterface = isInterface;
		_isClass = isClass;
		_isAbstract = isAbstract;
	}

	String _id;
	String _package;

	Collection<ClassElement> _parents = new Vector<ClassElement>();
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

	public String getId() {
		return _id;
	}

	public void addParent(ClassElement parent) {
		_parents.add(parent);
	}

	public boolean isInterface() {
		return _isInterface;
	}

	public boolean isClass() {
		return _isClass;
	}

	public boolean isAbstract() {
		return _isAbstract;
	}

	public Collection<ClassElement> getParents() {
		return _parents;
	}

	public Collection<FieldElement> getFields() {
		return _fields;
	}

	public Collection<MethodElement> getMethods() {
		return _methods;
	}

}
