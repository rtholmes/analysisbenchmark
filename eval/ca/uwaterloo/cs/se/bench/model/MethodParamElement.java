package ca.uwaterloo.cs.se.bench.model;

public class MethodParamElement extends TypeReferenceElement {
	public MethodParamElement(ClassElement type, int order) {
		super(type);

		_order = order;
	}

	final int _order;

	int getOrder() {
		return _order;
	}

}
