package ca.uwaterloo.cs.se.bench.model;

import java.util.Vector;

public class MethodParamElement {
	String _id; // might not need this (e.g., param name)
	ClassElement _type;
	Vector<ClassElement> _generics = new Vector<ClassElement>();
	int order = -1;
	boolean _isArray = false;
	int _arrayDimensions = -1;
}
