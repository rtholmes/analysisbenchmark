package ca.uwaterloo.cs.se.bench.model;

public class AbstractElement {

	protected String _id = null;

	protected boolean _isExternal = true;

	public String getId() {
		return _id;
	}

	public boolean isExternal() {
		return _isExternal;
	}
}
