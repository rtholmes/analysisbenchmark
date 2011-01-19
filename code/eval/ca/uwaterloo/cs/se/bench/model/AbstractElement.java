package ca.uwaterloo.cs.se.bench.model;

public class AbstractElement {

	protected boolean _isExternal = true;

	protected String _id = null;

	public boolean isExternal() {
		return _isExternal;
	}

	public String getId() {
		return _id;
	}
}
