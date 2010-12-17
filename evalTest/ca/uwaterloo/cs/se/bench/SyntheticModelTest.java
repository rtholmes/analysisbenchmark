package ca.uwaterloo.cs.se.bench;

import java.util.Collection;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.uwaterloo.cs.se.bench.model.ClassElement;
import ca.uwaterloo.cs.se.bench.model.Model;
import ca.uwaterloo.cs.se.bench.model.io.XMLReaderDependencyFinder;

/**
 * Synthetic test; essentially makes sure the eval code is working separate from
 * the suite that will actually test the model.
 * 
 * @author rtholmes
 * 
 */
public class SyntheticModelTest {

	private final String fName = "testResources/static_synthetic.xml";
	private Model _model;

	@BeforeClass
	public static void beforeClass() {
		XMLReaderDependencyFinder.startLog4J(true);
	}

	@Before
	public void initModel() {

		XMLReaderDependencyFinder xmlrdf = new XMLReaderDependencyFinder(fName);
		_model = xmlrdf.parseModel();

		Assert.assertNotNull(_model);
	}

	@Test
	public void parseInhInterface() {
		ClassElement ce = _model.getClass("ca.uwaterloo.cs.se.bench.simple.InhInterface");
		Assert.assertNotNull(ce);

		Assert.assertTrue(ce.isInterface());
		Assert.assertFalse(ce.isClass());
		Assert.assertFalse(ce.isAbstract());

		Assert.assertEquals(0, ce.getParents().size());
		Assert.assertEquals(0, ce.getFields().size());
		Assert.assertEquals(0, ce.getMethods().size());
	}

	@Test
	public void parseInhAbstractClass() {
		ClassElement ce = _model.getClass("ca.uwaterloo.cs.se.bench.simple.InhAbstractClass");
		Assert.assertNotNull(ce);

		Assert.assertFalse(ce.isInterface());
		Assert.assertFalse(ce.isClass());
		Assert.assertTrue(ce.isAbstract());

		Assert.assertEquals(1, ce.getParents().size());
		Assert.assertEquals(0, ce.getFields().size());
		Assert.assertEquals(0, ce.getMethods().size());

		Assert.assertEquals(_model.getClass("ca.uwaterloo.cs.se.bench.simple.InhInterface"), ce.getParents().iterator().next());
	}

	@Test
	public void parseInhClassA() {
		ClassElement ce = _model.getClass("ca.uwaterloo.cs.se.bench.simple.InhClassA");
		Assert.assertNotNull(ce);

		Assert.assertFalse(ce.isInterface());
		Assert.assertTrue(ce.isClass());
		Assert.assertFalse(ce.isAbstract());

		Assert.assertEquals(1, ce.getParents().size());
		Assert.assertEquals(0, ce.getFields().size());
		Assert.assertEquals(0, ce.getMethods().size());
		
		Assert.assertEquals(_model.getClass("ca.uwaterloo.cs.se.bench.simple.InhAbstractClass"), ce.getParents().iterator().next());
	}
	
	

}
