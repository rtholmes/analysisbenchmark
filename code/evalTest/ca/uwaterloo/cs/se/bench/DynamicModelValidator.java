package ca.uwaterloo.cs.se.bench;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.uwaterloo.cs.se.bench.model.MethodElement;
import ca.uwaterloo.cs.se.bench.model.Model;
import ca.uwaterloo.cs.se.bench.model.io.XMLReaderDependencyFinder;
import ca.uwaterloo.cs.se.bench.model.io.XMLReaderDynamicTracer;

public class DynamicModelValidator {

	protected Model _model;

	private final String fName = "report/dynamic/latestDynamic.xml";

	@Before
	public void initModel() {
		XMLReaderDynamicTracer xmlrdf = new XMLReaderDynamicTracer(fName);
		_model = xmlrdf.parseModel();

		Assert.assertNotNull(_model);
	}

	@BeforeClass
	public static void beforeClass() {
		XMLReaderDependencyFinder.startLog4J(true);
	}

	@Test
	public void testA1callsA2() {
		MethodElement a1 = _model.getMethod("ca.uwaterloo.cs.se.bench.simple.SimpleClass.a1()");
		MethodElement a2 = _model.getMethod("ca.uwaterloo.cs.se.bench.simple.SimpleClass.a2()");

		Assert.assertNotNull(a1);
		Assert.assertNotNull(a2);

		Assert.assertTrue(a1.getCalls().contains(a2));
	}
}
