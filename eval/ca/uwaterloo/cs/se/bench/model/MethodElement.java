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
	// Collection<MethodElement> _methods = new Vector<MethodElement>();
	Collection<String> _calls = new Vector<String>();
	MethodReturnElement _return;

	public void setParams(List<MethodParamElement> params) {
		_params = params;
	}

	public void setReturn(MethodReturnElement mre) {
		_return = mre;
	}

	public void setCalls(Collection<String> calls) {
		_calls = calls;
	}
}
