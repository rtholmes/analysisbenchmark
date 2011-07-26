package ca.uwaterloo.cs.se.bench.simple;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import ca.uwaterloo.cs.se.inconsistency.core.model2.Model;
import ca.uwaterloo.cs.se.inconsistency.core.model2.io.XMLReaderDependencyFinder;
import ca.uwaterloo.cs.se.inconsistency.core.model2.io.XMLReaderDynamicTracer;

public class AbstractValidation {

	protected Model _staticModel;
	protected Model _dynamicModel;

	private final String _staticDataFile = "report/static/static_latest.xml";
	private final String _dynamicDataFile = "report/dynamic/latestDynamic.xml";

	@Before
	public void initModels() {

		XMLReaderDependencyFinder xmlrdf = new XMLReaderDependencyFinder(_staticDataFile);
		Assert.assertNotNull(xmlrdf);
		_staticModel = xmlrdf.parseModel();
		Assert.assertNotNull(_staticModel);

		XMLReaderDynamicTracer xmlrdt = new XMLReaderDynamicTracer(_dynamicDataFile);
		Assert.assertNotNull(xmlrdt);
		_dynamicModel = xmlrdt.parseModel();
		Assert.assertNotNull(_dynamicModel);
	}

	@BeforeClass
	public static void beforeClass() {
		XMLReaderDependencyFinder.startLog4J(true);
	}

	@Test
	public void testAbstractValidation() {
		// Dummy test case to keep JUnit happy. This class isn't a real test class, all other test classes extend it.
		Assert.assertTrue(true);
	}
}
