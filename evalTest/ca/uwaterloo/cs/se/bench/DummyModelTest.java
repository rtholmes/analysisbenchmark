package ca.uwaterloo.cs.se.bench;

import java.util.Collection;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import ca.uwaterloo.cs.se.bench.model.ClassElement;
import ca.uwaterloo.cs.se.bench.model.io.XMLReaderDependencyFinder;

public class DummyModelTest {

	private final String fName = "testResources/staticDummy.xml";

	@BeforeClass
	public static void beforeClass() {
		XMLReaderDependencyFinder.startLog4J(true);
	}

	@Test
	public void parseDummyModel() {

		XMLReaderDependencyFinder xmlrdf = new XMLReaderDependencyFinder(fName);
		Collection<ClassElement> model = xmlrdf.parseModel();

		Assert.assertNotNull(model);
	}
	
	
}
