package ca.uwaterloo.cs.se.bench.model;

import java.util.Hashtable;
import java.util.Map;

public class Model {

	Map<String, ClassElement> _classes = new Hashtable<String, ClassElement>();
	Map<String, FieldElement> _fields = new Hashtable<String, FieldElement>();

	Map<String, MethodElement> _methods = new Hashtable<String, MethodElement>();

	public void addElement(ClassElement ce) {
		if (hasClass(ce.getId())) {
			throw new RuntimeException("Class already exists: " + ce.getId());
		}
		_classes.put(ce.getId(), ce);
	}

	public void addElement(FieldElement fe) {
		if (hasField(fe.getId())) {
			throw new RuntimeException("Field already exists: " + fe.getId());
		}
		_fields.put(fe.getId(), fe);
	}

	public void addElement(MethodElement me) {
		if (hasMethod(me.getId())) {
			throw new RuntimeException("Method already exists: " + me.getId());
		}
		_methods.put(me.getId(), me);
	}

	public ClassElement getClass(String id) {
		if (!hasClass(id)) {
			throw new RuntimeException("Unknown: " + id);
		}
		return _classes.get(id);
	}

	public FieldElement getField(String id) {
		if (!hasField(id)) {
			throw new RuntimeException("Unknown: " + id);
		}
		return _fields.get(id);
	}

	public MethodElement getMethod(String id) {
		if (!hasMethod(id)) {
			throw new RuntimeException("Unknown: " + id);
		}
		return _methods.get(id);
	}

	public boolean hasClass(String id) {
		return _classes.containsKey(id);
	}

	public boolean hasField(String id) {
		return _fields.containsKey(id);
	}

	public boolean hasMethod(String id) {
		return _methods.containsKey(id);
	}

}
