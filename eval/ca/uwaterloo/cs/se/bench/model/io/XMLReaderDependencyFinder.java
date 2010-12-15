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

import ca.uwaterloo.cs.se.bench.model.ClassElement;

public class XMLReaderDependencyFinder implements XMLSchema {
	private Logger _log = Logger.getLogger(getClass());

	private String _fName;

	public static final String LOG_PATTERN_VERBOSE = "%5p %d (%F:%L) - %m%n";

	/**
	 * This logger pattern is much faster as it does not have to compute class/line numbers on the fly.
	 */
	public static final String LOG_PATTERN_FAST = "%5p - %m%n";

	public XMLReaderDependencyFinder(String fName) {
		_fName = fName;
	}

	/**
	 * The default Logger level will be INFO using this method. If you want a different level use one of the methods
	 * that takes a level parameter.
	 * 
	 * @param verbose
	 *            true for the verbose pattern; false for the fast pattern.
	 */
	public static void startLog4J(boolean verbose) {
		// We don't want any duplicate appenders laying around
		Logger.getRootLogger().removeAllAppenders();

		BasicConfigurator.configure();

		// This is bad form but BasicConfigurator only adds one appender so it works out just fine
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
			String id = classElement.getAttributeValue(ID);
			ClassElement ce = new ClassElement(id);
			modelClasses.add(ce);
		}

		return modelClasses;
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
