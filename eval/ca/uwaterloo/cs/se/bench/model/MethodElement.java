package ca.uwaterloo.cs.se.bench.model;

import java.util.Collection;
import java.util.List;
import java.util.Vector;

public class MethodElement extends AnnotatableElement {
	public MethodElement(String id) {
		_id = id;
	}

	String _id;

	List<MethodParamElement> _params = new Vector<MethodParamElement>();
	Collection<MethodElement> _callTargets = new Vector<MethodElement>();

	MethodReturnElement _return;

	public void setParams(List<MethodParamElement> params) {
		_params = params;
	}

	public void setReturn(MethodReturnElement mre) {
		_return = mre;
	}

	public String getId() {
		return _id;
	}

	public void addCallTarget(MethodElement target) {
		_callTargets.add(target);
	}
}
