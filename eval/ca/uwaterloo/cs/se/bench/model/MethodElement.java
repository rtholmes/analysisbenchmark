package ca.uwaterloo.cs.se.bench.model;

import java.util.Collection;
import java.util.List;
import java.util.Vector;

public class MethodElement extends AnnotatableElement{
	String _id;

	List<MethodParamElement> _params = new Vector<MethodParamElement>();
	Collection<MethodElement> _methods = new Vector<MethodElement>();
	MethodReturnElement _return;
}
