package ca.uwaterloo.cs.se.bench.model.io;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import ca.uwaterloo.cs.se.bench.model.ClassElement;
import ca.uwaterloo.cs.se.bench.model.MethodElement;
import ca.uwaterloo.cs.se.bench.model.Model;

public class XMLReaderDynamicTracer {

	private String _fName;
	private Model _model;

	public XMLReaderDynamicTracer(String fName) {
		_fName = fName;
		if (!new File(_fName).exists()) {
			throw new RuntimeException("File " + new File(fName).getAbsolutePath() + " does not exist");
		}

		_model = new Model();

		insertDefaultData();
	}

	private void insertDefaultData() {
		// add the void type
		_model.addElement(new ClassElement("byte", true));
		_model.addElement(new ClassElement("char", true));
		_model.addElement(new ClassElement("double", true));
		_model.addElement(new ClassElement("float", true));
		_model.addElement(new ClassElement("int", true));
		_model.addElement(new ClassElement("long", true));
		_model.addElement(new ClassElement("short", true));
		_model.addElement(new ClassElement("void", true));
		_model.addElement(new ClassElement("boolean", true));

		// conversion.put("B", "byte");
		// conversion.put("C", "char");
		// conversion.put("D", "double");
		// conversion.put("F", "float");
		// conversion.put("I", "int");
		// conversion.put("J", "long");
		// conversion.put("S", "short");
		// conversion.put("V", "void");
		// conversion.put("Z", "boolean");
	}

	private Document readDocument(String fName) {
		SAXBuilder builder = new SAXBuilder(false);
		Document doc = null;

		try {

			doc = builder.build(new File(fName));

		} catch (JDOMException jdome) {
			jdome.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return doc;
	}

	@SuppressWarnings("unchecked")
	public Model parseModel() {

		// Session session = new Session(fName);
		// Model model = new Model();
		Document doc = readDocument(_fName);

		Element rootElement = doc.getRootElement();

		Element staticElement = rootElement.getChild("static");

		for (Element methodElem : (List<Element>) staticElement.getChild("methods").getChildren("method")) {

			String methodName = methodElem.getAttributeValue("name");
			if (!DynamicTracerSchema.ignoreName(methodName))
				convertMethod(methodName, _model);

		}

		// RFE: don't load fields for now
		// for (Element fieldElem : (List<Element>) staticElement.getChild("fields").getChildren("field")) {
		//
		// String fieldName = fieldElem.getAttributeValue("name");
		// FieldElement fe = convertField(fieldName, session);
		//
		// }

		// edges
		Element dynamicElement = rootElement.getChild("dynamic");
		for (Element targetElem : (List<Element>) dynamicElement.getChild("methods").getChildren("method")) {
			String targetName = targetElem.getAttributeValue("name");

			for (Element sourceElem : (List<Element>) targetElem.getChildren("calledBy")) {

				String sourceName = sourceElem.getAttributeValue("name");
				if (DynamicTracerSchema.ignoreName(sourceName) || DynamicTracerSchema.ignoreName(targetName)) {

				} else {

					// XXX: this is huge! names are backwards in current trace
					MethodElement targetMethod = convertMethod(targetName, _model);
					MethodElement sourceMethod = convertMethod(sourceName, _model);
					// HACK: above is how it should be
					// MethodElement targetMethod = convertMethod(sourceName, session);
					// MethodElement sourceMethod = convertMethod(targetName, session);
					// if (targetMethod.getName().contains("<clinit>") || ILonganIO.ignoreName(targetName)) {
					//
					// } else {
					if (sourceMethod != null && targetMethod != null) {
						sourceMethod.getCalls().add(targetMethod);
						// targetMethod.getCalledBy().add(sourceMethod.getId());
					}
					// }
				}
			}
		}

		// RFE: field references not being parsed because they just aren't happening
		// for (Element targetElem : (List<Element>) dynamicElement.getChild("fields").getChildren("field")) {
		//
		// MethodElement targetMethod = convertMethod(targetElem.getAttributeValue("name"), session);
		// for (Element sourceElem : (List<Element>) targetElem.getChildren("calledBy")) {
		// MethodElement sourceMethod = convertMethod(sourceElem.getAttributeValue("name"), session);
		//
		// if (targetMethod.getName().contains("<clinit>")) {
		//
		// } else {
		// if (sourceMethod != null && targetMethod != null) {
		// targetMethod.getCalledBy().add(sourceMethod.getId());
		// }
		// }
		// }
		// }

		return _model;
	}

	//
	// private FieldElement convertField(String fieldName, Model session) {
	// int id = -1;
	//
	// if (!session.hasIDForElement(fieldName)) {
	// // session.addIDForElement(fieldName, _nextId++);
	// id = _nextId++;
	// } else {
	// id = session.getIdForElement(fieldName);
	// }
	//
	// if (!session.fieldExists(id)) {
	// session.addField(id, new FieldElement(id, fieldName));
	// }
	// return session.getFieldForName(fieldName);
	// }

	private MethodElement convertMethod(String methodName, Model session) {
		int id = -1;

		methodName = standardizeMethodName(methodName);

		System.out.println("ConvertMethod " + methodName);

		// if (!session.hasIDForElement(methodName)) {
		// id = _nextId++;
		// } else {
		// id = session.getIdForElement(methodName);
		// }
		// if (!session.methodExists(id)) {
		// session.addMethod(id, new MethodElement(id, methodName, false));
		// }

		if (!session.hasMethod(methodName)) {
			MethodElement me = new MethodElement(methodName);
			session.addElement(me);
		}

		return session.getMethod(methodName);
	}

	private String standardizeMethodName(String originalName) {
		if (originalName.equals(""))
			return originalName;

		// // XXX: if the object is a constructor, don't do this, it'll trim to the first parameter this way
		//
		// int firstSpace = originalName.indexOf(' ');
		//
		// // the whole point of this is to strip off the return type, but this shouldn't be fully-qualified anyways
		// if (firstSpace > 0 && originalName.substring(0, firstSpace).indexOf(".") < 0) {
		// String newName = "";
		// if (firstSpace > 0)
		// newName = originalName.substring(firstSpace + 1);
		// // _log.trace("dyn name trans: " + originalName + " -> " + newName);
		//
		// return newName;
		// }
		//
		// // _log.trace("dyn name same: " + originalName);
		// return originalName;
		// // return newName;

		return translateMethodName(originalName);
	}

	private String translateMethodName(String fullName) {
		if (true)
			return fullName;

		String unqualifiedMethodName = "";
		// String fullName = method.getName();

		int firstBrace = -1;
		int lastBrace = -1;

		firstBrace = fullName.indexOf("(");
		lastBrace = fullName.lastIndexOf(")");

		if (firstBrace < 1) {
			firstBrace = fullName.indexOf("<");
			lastBrace = fullName.lastIndexOf(">");
		}

		int lastdot = fullName.lastIndexOf(".", firstBrace);
		int typedot = fullName.lastIndexOf(".", lastdot - 1);
		int firstSpace = fullName.indexOf(' ');

		String returnTupe = null;
		String nameQualifier = null;
		if (firstSpace >= 0) {
			returnTupe = fullName.substring(0, firstSpace);
			nameQualifier = fullName.substring(firstSpace + 1, typedot + 1);
		} else {
			nameQualifier = fullName.substring(0, typedot + 1);
		}

		String typeMethodName = fullName.substring(typedot + 1, firstBrace + 1);

		String parameterList = fullName.substring(firstBrace + 1, lastBrace);

		// JIILcom.imprev.entity.SortOptions;Z -> J,I,I,Lcom.imprev.entity.SortOptions;,Z
		// String shortParameterList = "";
		// if (parameterList.length() > 0) {
		// for (int i = 0; i< parameterList.length(); i++){
		//
		// }
		//
		//
		// }

		// .<init>(Lorg.eclipse.swt.widgets.Shell;,I,I,Ljava.lang.String;,Ljava.lang.String;)
		String shortParameterList = "";
		// if (parameterList.length() > 0) {
		// String[] params = parameterList.split(";");
		//
		// for (String param : params) {
		// String[] innerParams = param.split(",");
		//
		// // java.io.ByteArrayInputStream([B[])
		//
		// for (String p : innerParams) {
		// if (p.length() >= 1) {
		// boolean is1Darray = false;
		// boolean is2Darray = false;
		//
		// is2Darray = p.startsWith("[[");
		// if (!is2Darray)
		// is1Darray = p.startsWith("[");
		//
		// String shortParam = "";
		//
		// if (p.lastIndexOf(".") > 0)
		// shortParam = p.substring(p.lastIndexOf(".") + 1, p.length());
		// else {
		// // it's a primitive
		// if (is1Darray || is2Darray) {
		// shortParam = p.substring(p.lastIndexOf('[') + 1, p.length());
		// } else {
		// shortParam = p.substring(p.lastIndexOf(".") + 1, p.length());
		// }
		// }
		//
		// if (shortParam.length() == 1)
		// shortParam = translatePrimitive(shortParam);
		//
		// if (is2Darray)
		// shortParam += "[][]";
		// if (is1Darray)
		// shortParam += "[]";
		//
		// shortParameterList += shortParam + ", ";
		// }
		// }
		// }
		//
		// // get rid of the trailing comma
		// shortParameterList = shortParameterList.substring(0, shortParameterList.length() - 2);
		// }

		String methodName = nameQualifier + typeMethodName + shortParameterList + fullName.charAt(lastBrace);
		// // longan does not have init designations
		// methodName = methodName.replace(".<init>", "");
		// // longan does not keep $s in names (although they are in the type sigs)
		// methodName = methodName.replace("$", ".");
		//
		// if (methodName.equals("CountDownLatch, Runnable)")) {
		// System.err.println("");
		// }

		return methodName;
	}

	private String translatePrimitive(String shortParam) {
		if (shortParam.equals("B")) {
			return "byte";
		} else if (shortParam.equals("C")) {
			return "char";
		} else if (shortParam.equals("D")) {
			return "double";
		} else if (shortParam.equals("F")) {
			return "float";
		} else if (shortParam.equals("I")) {
			return "int";
		} else if (shortParam.equals("J")) {
			return "long";
		} else if (shortParam.equals("S")) {
			return "short";
		} else if (shortParam.equals("Z")) {
			return "boolean";
		}
		return shortParam;
		// B byte signed byte
		// C char character
		// D double double precision IEEE float
		// F float single precision IEEE float
		// I int integer
		// J long long integer
		// L; ... an object of the given class
		// S short signed short
		// Z boolean true or false

	}
}
