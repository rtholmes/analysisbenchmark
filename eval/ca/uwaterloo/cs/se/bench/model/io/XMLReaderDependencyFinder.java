package ca.uwaterloo.cs.se.bench.model.io;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import ca.uwaterloo.cs.se.bench.model.AnnotationElement;
import ca.uwaterloo.cs.se.bench.model.ClassElement;
import ca.uwaterloo.cs.se.bench.model.FieldElement;
import ca.uwaterloo.cs.se.bench.model.MethodElement;
import ca.uwaterloo.cs.se.bench.model.MethodParamElement;
import ca.uwaterloo.cs.se.bench.model.MethodReturnElement;

public class XMLReaderDependencyFinder implements XMLSchema {
	private Logger _log = Logger.getLogger(getClass());

	private String _fName;

	public static final String LOG_PATTERN_VERBOSE = "%5p %d (%F:%L) - %m%n";

	/**
	 * This logger pattern is much faster as it does not have to compute
	 * class/line numbers on the fly.
	 */
	public static final String LOG_PATTERN_FAST = "%5p - %m%n";

	public XMLReaderDependencyFinder(String fName) {
		_fName = fName;
	}

	/**
	 * The default Logger level will be INFO using this method. If you want a
	 * different level use one of the methods that takes a level parameter.
	 * 
	 * @param verbose
	 *            true for the verbose pattern; false for the fast pattern.
	 */
	public static void startLog4J(boolean verbose) {
		// We don't want any duplicate appenders laying around
		Logger.getRootLogger().removeAllAppenders();

		BasicConfigurator.configure();

		// This is bad form but BasicConfigurator only adds one appender so it
		// works out just fine
		ConsoleAppender ca = (ConsoleAppender) Logger.getRootLogger().getAllAppenders().nextElement();

		if (ca != null)
			if (verbose)
				ca.setLayout(new PatternLayout(LOG_PATTERN_VERBOSE));
			else
				ca.setLayout(new PatternLayout(LOG_PATTERN_FAST));

		Logger.getRootLogger().setLevel(Level.INFO);
	}

	public Collection<ClassElement> parseModel() {
		Document doc = readDocument(_fName);

		Collection<ClassElement> modelClasses = new Vector<ClassElement>();

		// do the parsing
		@SuppressWarnings("unchecked")
		List<Element> classes = doc.getRootElement().getChildren(CLASS);
		for (Element classElement : classes) {
			ClassElement ce = parseClassElement(classElement);

			modelClasses.add(ce);
		}

		return modelClasses;
	}

	@SuppressWarnings("unchecked")
	private ClassElement parseClassElement(Element classElement) {
		String id = null;
		boolean isInterface = false;
		boolean isClass = false;

		if (hasAttribute(classElement, ID)) {
			id = classElement.getAttributeValue(ID);
		} else {
			throw new RuntimeException("ID must be set");
		}

		if (hasAttribute(classElement, IS_INTERFACE))
			isInterface = Boolean.parseBoolean(classElement.getAttributeValue(IS_INTERFACE));

		if (hasAttribute(classElement, IS_CLASS))
			isClass = Boolean.parseBoolean(classElement.getAttributeValue(IS_CLASS));

		ClassElement ce = new ClassElement(id, isInterface, isClass);

		if (classElement.getChild(FIELDS) != null) {
			Collection<FieldElement> fields = parseFields(classElement.getChild(FIELDS).getChildren());
			ce.setFields(fields);
		}

		if (classElement.getChild(METHODS) != null) {
			Collection<MethodElement> methods = parseMethods(classElement.getChild(METHODS).getChildren());
			ce.setMethods(methods);
		}

		if (classElement.getChild(ANNOTATIONS) != null) {
			Collection<AnnotationElement> annotations = parseAnnotations(classElement.getChild(ANNOTATIONS).getChildren());

			ce.setAnnotaions(annotations);
		}

		return ce;
	}

	private Collection<AnnotationElement> parseAnnotations(List<Element> annotationElements) {
		Collection<AnnotationElement> annotations = new Vector<AnnotationElement>();
		if (annotationElements == null) {
			return annotations;
		}

		for (Element annotationElement: annotationElements){
			String type = annotationElement.getAttributeValue(TYPE);
			AnnotationElement ae = new AnnotationElement(type);
			annotations.add(ae);
		}
		
		return annotations;
	}

	private Vector<FieldElement> parseFields(List<Element> fieldElements) {
		Vector<FieldElement> fields = new Vector<FieldElement>();

		if (fieldElements == null) {
			return fields;
		}

		for (Element fieldElement : fieldElements) {
			String id = fieldElement.getAttributeValue(ID);
			String type = fieldElement.getAttributeValue(TYPE);

			FieldElement fe = new FieldElement(id, type);
			fields.add(fe);
		}

		return fields;
	}

	@SuppressWarnings("unchecked")
	private Vector<MethodElement> parseMethods(List<Element> methodElements) {
		Vector<MethodElement> methods = new Vector<MethodElement>();
		if (methodElements == null) {
			return methods;
		}

		for (Element methodElement : methodElements) {
			String id = methodElement.getAttributeValue(ID);
			MethodElement me = new MethodElement(id);

			if (methodElement.getChild(PARAMS) != null) {
				List<MethodParamElement> params = parseParams(methodElement.getChild(PARAMS).getChildren());
				me.setParams(params);
			}

			if (methodElement.getChild(RETURN) != null) {
				MethodReturnElement mre = parseReturnType(methodElement.getChild(RETURN));
				me.setReturn(mre);
			} else {
				throw new RuntimeException("fill me in");
			}

			if (methodElement.getChild(CALLS) != null) {
				Collection<String> params = parseCalls(methodElement.getChild(CALLS).getChildren());
				me.setCalls(params);
			}
		}

		return methods;
	}

	private Collection<String> parseCalls(List<Element> callElements) {
		Collection<String> calls = new Vector<String>();
		if (callElements == null) {
			return calls;
		}

		for (Element callElement : callElements) {
			String id = callElement.getAttributeValue(ID);
			calls.add(id);
		}

		return calls;
	}

	private MethodReturnElement parseReturnType(Element returnElement) {

		String type = returnElement.getAttributeValue(TYPE);

		MethodReturnElement mre = new MethodReturnElement(type);

		return mre;
	}

	private Vector<MethodParamElement> parseParams(List<Element> paramElements) {
		Vector<MethodParamElement> params = new Vector<MethodParamElement>();
		if (paramElements == null) {
			return params;
		}

		for (Element paramElement : paramElements) {
			String id = paramElement.getAttributeValue(ID);
			String type = paramElement.getAttributeValue(TYPE);
			int order = Integer.parseInt(paramElement.getAttributeValue(ORDER));

			MethodParamElement mpe = new MethodParamElement(id, type, order);
			params.add(mpe);
		}

		return params;
	}

	private boolean hasAttribute(Element classElement, String attrName) {
		return classElement.getAttribute(attrName) != null;
	}

	private Document readDocument(String fName) {
		SAXBuilder builder = new SAXBuilder(false);
		Document doc = null;

		try {

			doc = builder.build(new File(fName));

		} catch (JDOMException jdome) {
			_log.error(jdome);
		} catch (IOException ioe) {
			_log.error(ioe);
		}
		return doc;
	}
}
