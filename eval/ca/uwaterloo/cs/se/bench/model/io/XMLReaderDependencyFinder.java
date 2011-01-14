package ca.uwaterloo.cs.se.bench.model.io;

import java.io.File;
import java.io.IOException;
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

import ca.uwaterloo.cs.se.bench.model.ClassElement;
import ca.uwaterloo.cs.se.bench.model.FieldElement;
import ca.uwaterloo.cs.se.bench.model.MethodElement;
import ca.uwaterloo.cs.se.bench.model.MethodParamElement;
import ca.uwaterloo.cs.se.bench.model.MethodReturnElement;
import ca.uwaterloo.cs.se.bench.model.Model;

public class XMLReaderDependencyFinder implements XMLSchema {
	private Logger _log = Logger.getLogger(getClass());

	private String _fName;

	private Model _model;

	public static final String LOG_PATTERN_VERBOSE = "%5p %d (%F:%L) - %m%n";

	/**
	 * This logger pattern is much faster as it does not have to compute
	 * class/line numbers on the fly.
	 */
	public static final String LOG_PATTERN_FAST = "%5p - %m%n";

	public XMLReaderDependencyFinder(String fName) {
		_fName = fName;
		if (!new File(_fName).exists()) {
			throw new RuntimeException();
		}
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

	@SuppressWarnings("unchecked")
	public Model parseModel() {
		_model = new Model();

		Document doc = readDocument(_fName);
		Element rootElement = doc.getRootElement();

		// declarations (e.g., classes)
		Element declarationsElement = rootElement.getChild(DECLARATIONS);

		List<Element> classDeclarationElements = declarationsElement.getChild(CLASSES).getChildren();
		for (Element classElement : classDeclarationElements) {
			parseClassElement(classElement);
		}

		// contains (e.g., methods and fields)
		List<Element> containsDeclarationElements = declarationsElement.getChild(CONTAINS).getChildren();
		for (Element classElement : containsDeclarationElements) {
			parseClassContainsElement(classElement);
		}

		// relationships (e.g., calls, references, intherits)
		Element relationshipsElement = rootElement.getChild(RELATIONSHIPS);
		if (relationshipsElement == null) {
			throw new RuntimeException("XML should contain a " + RELATIONSHIPS + " element.");
		}

		if (relationshipsElement.getChild(CALLS) != null) {
			List<Element> callElements = relationshipsElement.getChild(CALLS).getChildren();
			for (Element callElement : callElements) {
				parseCall(callElement);
			}
		}

		if (relationshipsElement.getChild(REFERENCES) != null) {
			List<Element> referenceElements = relationshipsElement.getChild(REFERENCES).getChildren();
			for (Element refElement : referenceElements) {
				parseReference(refElement);
			}
		}

		if (relationshipsElement.getChild(INHERITS) != null) {
			List<Element> inheritsElements = relationshipsElement.getChild(INHERITS).getChildren();
			for (Element inheritElement : inheritsElements) {
				parseInheritance(inheritElement);
			}
		}

		return _model;
	}

	@SuppressWarnings("unchecked")
	private void parseClassContainsElement(Element classContainsElement) {
		String id = classContainsElement.getAttributeValue(ID);
		ClassElement ce = _model.getClass(id);

		List<Element> methodElements = classContainsElement.getChildren(METHOD);
		Vector<MethodElement> methods = parseMethods(methodElements);
		ce.setMethods(methods);

		List<Element> fieldElements = classContainsElement.getChildren(FIELD);
		Vector<FieldElement> fields = parseFields(fieldElements);
		ce.setFields(fields);
	}

	private void parseClassElement(Element classElement) {
		String id = null;
		boolean isInterface = false;
		boolean isClass = false;
		boolean isAbstract = false;
		boolean isExternal = false;

		if (hasAttribute(classElement, ID)) {
			id = classElement.getAttributeValue(ID);
		} else {
			throw new RuntimeException("ID must be set");
		}

		if (hasAttribute(classElement, IS_INTERFACE))
			isInterface = Boolean.parseBoolean(classElement.getAttributeValue(IS_INTERFACE));

		if (hasAttribute(classElement, IS_CLASS))
			isClass = Boolean.parseBoolean(classElement.getAttributeValue(IS_CLASS));

		if (hasAttribute(classElement, IS_ABSTRACT))
			isAbstract = Boolean.parseBoolean(classElement.getAttributeValue(IS_ABSTRACT));

		if (hasAttribute(classElement, IS_EXTERNAL))
			isExternal = Boolean.parseBoolean(classElement.getAttributeValue(IS_EXTERNAL));

		if (!_model.hasClass(id)) {
			ClassElement ce = new ClassElement(id, isExternal, isInterface, isClass, isAbstract);
			_model.addElement(ce);
		} else {
			throw new RuntimeException();
		}
	}

	// private Collection<AnnotationElement> parseAnnotations(List<Element>
	// annotationElements) {
	// Collection<AnnotationElement> annotations = new
	// Vector<AnnotationElement>();
	// if (annotationElements == null) {
	// return annotations;
	// }
	//
	// for (Element annotationElement : annotationElements) {
	// String type = annotationElement.getAttributeValue(TYPE);
	// AnnotationElement ae = new AnnotationElement(type);
	// annotations.add(ae);
	// }
	//
	// return annotations;
	// }

	private Vector<FieldElement> parseFields(List<Element> fieldElements) {
		Vector<FieldElement> fields = new Vector<FieldElement>();

		if (fieldElements == null) {
			return fields;
		}

		for (Element fieldElement : fieldElements) {
			String id = fieldElement.getAttributeValue(ID);
			String typeId = fieldElement.getAttributeValue(TYPE);
			ClassElement ce = _model.getClass(typeId);

			FieldElement fe = new FieldElement(id, ce);
			fields.add(fe);
			_model.addField(fe);
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
			methods.add(me);
			_model.addElement(me);

			if (methodElement.getChild(PARAMS) != null) {
				List<MethodParamElement> params = parseParams(methodElement.getChild(PARAMS).getChildren());
				me.setParams(params);
			}

			if (methodElement.getChild(RETURN) != null) {
				MethodReturnElement mre = parseReturnType(methodElement.getChild(RETURN));
				me.setReturn(mre);
			} else {
				me.setReturn(new MethodReturnElement(_model.getClass("V")));
			}
		}

		return methods;
	}

	private void parseCall(Element callElement) {

		String sourceID = callElement.getAttributeValue(SOURCE);
		String targetID = callElement.getAttributeValue(TARGET);

		MethodElement source = _model.getMethod(sourceID);
		MethodElement target = _model.getMethod(targetID);

		source.addCallTarget(target);
	}

	private void parseReference(Element refElement) {

		String sourceID = refElement.getAttributeValue(SOURCE);
		String targetID = refElement.getAttributeValue(TARGET);

		MethodElement source = _model.getMethod(sourceID);
		FieldElement target = _model.getField(targetID);

		source.addRefTarget(target);
	}

	private void parseInheritance(Element inhElement) {

		String childId = inhElement.getAttributeValue(CHILD);
		String parentId = inhElement.getAttributeValue(PARENT);

		ClassElement child = _model.getClass(childId);
		ClassElement parent = _model.getClass(parentId);

		child.addParent(parent);
	}

	private MethodReturnElement parseReturnType(Element returnElement) {

		String typeID = returnElement.getAttributeValue(ID);
		ClassElement ce = _model.getClass(typeID);

		MethodReturnElement mre = new MethodReturnElement(ce);

		return mre;
	}

	private Vector<MethodParamElement> parseParams(List<Element> paramElements) {
		Vector<MethodParamElement> params = new Vector<MethodParamElement>();

		if (paramElements == null) {
			return params;
		}

		for (Element paramElement : paramElements) {
			String typeId = paramElement.getAttributeValue(ID);
			ClassElement ce = _model.getClass(typeId);
			int order = Integer.parseInt(paramElement.getAttributeValue(ORDER));

			MethodParamElement mpe = new MethodParamElement(ce, order);
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
