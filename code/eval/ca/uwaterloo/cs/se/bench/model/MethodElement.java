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
	Collection<MethodElement> _calls = new Vector<MethodElement>();
	Collection<FieldElement> _references = new Vector<FieldElement>();

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
		_calls.add(target);
	}

	public void addRefTarget(FieldElement field) {
		_references.add(field);
	}

	public String toString() {
		return getId();
	}

	public Collection<MethodElement> getCalls() {
		return _calls;
	}

	public MethodReturnElement getReturnElement() {
		return _return;
	}

	public Collection<FieldElement> getReferences() {
		return _references;
	}

	public List<MethodParamElement> getParameters() {
		return _params;
	}
}
