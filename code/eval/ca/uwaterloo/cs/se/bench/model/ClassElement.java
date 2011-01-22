package ca.uwaterloo.cs.se.bench.model;

import java.util.Collection;
import java.util.Vector;

public class ClassElement extends AnnotatableElement {
	public ClassElement(String id, boolean isExternal, boolean isInterface, boolean isAbstract) {
		_id = id;
		_isExternal = isExternal;
		_isInterface = isInterface;
		_isAbstract = isAbstract;
	}

	/**
	 * If a class is external we don't have additional attributes for it.
	 * 
	 * @param id
	 * @param isExternal
	 */
	public ClassElement(String id, boolean isExternal) {
		_id = id;
		_isExternal = isExternal;
	}

	String _package;

	Collection<ClassElement> _parents = new Vector<ClassElement>();
	Collection<FieldElement> _fields = new Vector<FieldElement>();
	Collection<MethodElement> _methods = new Vector<MethodElement>();

	boolean _isInterface = false;
	boolean _isAbstract = false;

	// boolean _isExternal = false;

	public void setMethods(Collection<MethodElement> methods) {
		_methods = methods;
	}

	public void setFields(Collection<FieldElement> fields) {
		_fields = fields;
	}

	public void addParent(ClassElement parent) {
		_parents.add(parent);
	}

	public boolean isInterface() {
		return _isInterface;
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

	public String toString() {
		return getId();
	}
}
