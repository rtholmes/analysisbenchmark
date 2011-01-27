package ca.uwaterloo.cs.se.bench.model;

public class MethodReturnElement extends TypeReferenceElement {

	public MethodReturnElement(ClassElement type) {
		super(type);
	}

	public String toString() {
		return "MethodReturn: " + _type.toString();
	}

	public boolean equals(Object o) {
		if (o != null && o instanceof MethodReturnElement) {
			return ((MethodReturnElement) o).getType().equals(getType());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return getType().hashCode();
	}
}
