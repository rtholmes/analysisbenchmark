package ca.uwaterloo.cs.se.bench.model.io;

public interface DependencyFinderSchema {
	public static final String DECLARATIONS = "declarations";
	public static final String RELATIONSHIPS = "relationships";

	public static final String CONTAINS = "contains";
	public static final String CLASSES = "classes";
	public static final String CLASS = "ce";
	public static final String ID = "id";
	public static final String IS_INTERFACE = "isInt";
	public static final String IS_CLASS = "isClass";
	public static final String IS_ABSTRACT = "isAbs";
	public static final String IS_EXTERNAL= "isExt";
	public static final String PARAMS = "params";
	public static final String PARAM = "param";
	public static final String RETURN = "return";
	public static final String CALLS = "calls";
	public static final String CALL = "call";
	public static final String REFERENCES = "references";
	public static final String REFERENCE = "ref";
	public static final String INHERITS = "inherits";
	public static final String INHERIT = "inh";
	public static final String METHODS = "methods";
	public static final String METHOD = "me";
	public static final String FIELDS = "fields";
	public static final String FIELD = "fe";
	public static final String TYPE = "type";
	public static final String ANNOTATIONS = "annotations";
	public static final String ANNOTATION = "annotation";
	public static final String PARENTS = "parents";
	public static final String ORDER = "order";
	public static final String SOURCE = "s";
	public static final String TARGET = "t";
	public static final String PARENT = "p";
	public static final String CHILD = "c";
}
