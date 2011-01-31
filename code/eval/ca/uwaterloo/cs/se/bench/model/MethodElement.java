package ca.uwaterloo.cs.se.bench.model;

import java.util.Collection;
import java.util.List;
import java.util.Vector;

public class MethodElement extends AnnotatableElement {
	private Collection<MethodElement> _calls = new Vector<MethodElement>();

	private List<MethodParamElement> _params = new Vector<MethodParamElement>();
	private Collection<FieldElement> _references = new Vector<FieldElement>();
	MethodReturnElement _return;

	public MethodElement(String id) {
		_id = id;
	}

	public void addCallTarget(MethodElement target) {
		_calls.add(target);
	}

	public void addRefTarget(FieldElement field) {
		_references.add(field);
	}

	public Collection<MethodElement> getCalls() {
		return _calls;
	}

	public List<MethodParamElement> getParameters() {
		return _params;
	}

	public Collection<FieldElement> getReferences() {
		return _references;
	}

	public MethodReturnElement getReturnElement() {
		return _return;
	}

	public void setParams(List<MethodParamElement> params) {
		_params = params;
	}

	public void setReturn(MethodReturnElement mre) {
		_return = mre;
	}

	public String toString() {
		return getId();
	}
}
