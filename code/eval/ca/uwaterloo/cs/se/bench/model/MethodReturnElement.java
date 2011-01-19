package ca.uwaterloo.cs.se.bench.model;

public class MethodReturnElement extends TypeReferenceElement {

	public MethodReturnElement(ClassElement type) {
		super(type);
	}

	public String toString() {
		return "MethodReturn: " + _type.toString();
	}
}
