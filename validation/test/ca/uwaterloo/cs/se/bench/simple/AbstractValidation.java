package ca.uwaterloo.cs.se.bench.simple;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.uwaterloo.cs.se.inconsistency.core.model2.Model;
import ca.uwaterloo.cs.se.inconsistency.core.model2.io.Model2XMLReader;

public class AbstractValidation {

	protected Model _staticModel;
	protected Model _dynamicModel;

	private final String _staticDataFile = "report/latest_static.xml";
	private final String _dynamicDataFile = "report/latest_dynamic.xml";

	@Before
	public void initModels() {

		Model2XMLReader xmlrd;

		xmlrd = new Model2XMLReader(_staticDataFile);
		_staticModel = xmlrd.read();
		Assert.assertNotNull(_staticModel);

		xmlrd = new Model2XMLReader(_dynamicDataFile);
		_dynamicModel = xmlrd.read();
		Assert.assertNotNull(_dynamicModel);
	}

	@BeforeClass
	public static void beforeClass() {
		// NOTE: start logging
	}

	@Test
	public void testAbstractValidation() {
		// Dummy test case to keep JUnit happy. This class isn't a real test class, all other test classes extend it.
		Assert.assertTrue(true);
	}
}
