package ca.uwaterloo.cs.se.bench.model;

import java.util.Collection;
import java.util.Vector;

public class ClassElement extends AnnotatableElement {
	Collection<FieldElement> _fields = new Vector<FieldElement>();

	boolean _isAbstract = false;

	boolean _isInterface = false;

	Collection<MethodElement> _methods = new Vector<MethodElement>();
	String _package;
	Collection<ClassElement> _parents = new Vector<ClassElement>();

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
	public ClassElement(String id, boolean isExternal, boolean isInterface, boolean isAbstract) {
		_id = id;
		_isExternal = isExternal;
		_isInterface = isInterface;
		_isAbstract = isAbstract;
	}

	// boolean _isExternal = false;

	public void addParent(ClassElement parent) {
		_parents.add(parent);
	}

	@Override
	public boolean equals(Object obj) {
		return toString().equals(obj.toString());
	}

	public Collection<FieldElement> getFields() {
		return _fields;
	}

	public Collection<MethodElement> getMethods() {
		return _methods;
	}

	public Collection<ClassElement> getParents() {
		return _parents;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	public boolean isAbstract() {
		return _isAbstract;
	}

	public boolean isInterface() {
		return _isInterface;
	}

	public void setFields(Collection<FieldElement> fields) {
		_fields = fields;
	}

	public void setMethods(Collection<MethodElement> methods) {
		_methods = methods;
	}

	public String toString() {
		return getId();
	}
}
