package ca.uwaterloo.cs.se.bench.model;

import java.util.Collection;
import java.util.Vector;

public class AnnotatableElement extends AbstractElement {

	private Collection<AnnotationElement> _annotations = new Vector<AnnotationElement>();

	public void setAnnotaions(Collection<AnnotationElement> annotations) {
		_annotations = annotations;
	}

}