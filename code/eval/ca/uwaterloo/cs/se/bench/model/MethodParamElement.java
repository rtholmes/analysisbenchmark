package ca.uwaterloo.cs.se.bench.model;

public class MethodParamElement extends TypeReferenceElement {
	final int _order;

	public MethodParamElement(ClassElement type, int order) {
		super(type);

		_order = order;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof MethodParamElement) {
			MethodParamElement mpe = (MethodParamElement) o;
			return getType().equals(mpe.getType()) && getOrder() == mpe.getOrder();
		}
		return false;
	}

	public int getOrder() {
		return _order;
	}

	@Override
	public int hashCode() {
		return getType().hashCode() + getOrder() * 7;
	}
}
