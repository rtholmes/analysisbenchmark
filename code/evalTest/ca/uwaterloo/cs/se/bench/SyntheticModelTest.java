package ca.uwaterloo.cs.se.bench;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.uwaterloo.cs.se.bench.model.ClassElement;
import ca.uwaterloo.cs.se.bench.model.FieldElement;
import ca.uwaterloo.cs.se.bench.model.MethodElement;
import ca.uwaterloo.cs.se.bench.model.MethodParamElement;
import ca.uwaterloo.cs.se.bench.model.MethodReturnElement;
import ca.uwaterloo.cs.se.bench.model.Model;
import ca.uwaterloo.cs.se.bench.model.io.XMLReaderDependencyFinder;

/**
 * Synthetic test; essentially makes sure the eval code is working separate from the suite that will actually test the
 * model.
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
		Assert.assertFalse(ce.isAbstract());

		Assert.assertEquals(1, ce.getParents().size());
		Assert.assertEquals(0, ce.getFields().size());
		Assert.assertEquals(0, ce.getMethods().size());

		Assert.assertEquals(_model.getClass("ca.uwaterloo.cs.se.bench.simple.InhAbstractClass"), ce.getParents().iterator().next());
	}

	@Test
	public void parseCollection() {
		ClassElement ce = _model.getClass("java.util.Collection");
		Assert.assertNotNull(ce);

		Assert.assertTrue(ce.isExternal());

		Assert.assertEquals(0, ce.getParents().size());
		Assert.assertEquals(0, ce.getFields().size());
		Assert.assertEquals(0, ce.getMethods().size());
	}

	@Test
	public void parseVector() {
		ClassElement ce = _model.getClass("java.util.Vector");
		Assert.assertNotNull(ce);

		Assert.assertTrue(ce.isExternal());

		Assert.assertEquals(0, ce.getParents().size());
		Assert.assertEquals(0, ce.getFields().size());
		Assert.assertEquals(1, ce.getMethods().size());

		Assert.assertEquals("java.util.Vector.Vector()", ce.getMethods().iterator().next().getId());
	}

	@Test
	public void parseString() {
		ClassElement ce = _model.getClass("java.lang.String");
		Assert.assertNotNull(ce);

		Assert.assertTrue(ce.isExternal());

		Assert.assertEquals(0, ce.getParents().size());
		Assert.assertEquals(0, ce.getFields().size());
		Assert.assertEquals(0, ce.getMethods().size());
	}

	@Test
	public void parseV() {
		ClassElement ce = _model.getClass("void");
		Assert.assertNotNull(ce);

		Assert.assertTrue(ce.isExternal());

		Assert.assertEquals(0, ce.getParents().size());
		Assert.assertEquals(0, ce.getFields().size());
		Assert.assertEquals(0, ce.getMethods().size());
	}

	@Test
	public void parseSimpleClassStructure() {
		ClassElement ce = _model.getClass("ca.uwaterloo.cs.se.bench.simple.SimpleClass");
		Assert.assertNotNull(ce);

		Assert.assertFalse(ce.isExternal());

		Assert.assertEquals(0, ce.getParents().size());
		Assert.assertEquals(1, ce.getFields().size());
		Assert.assertEquals(7, ce.getMethods().size());

		Assert.assertEquals("ca.uwaterloo.cs.se.bench.simple.SimpleClass.fieldA", ce.getFields().iterator().next().getId());

		// TODO: ensure method is attached to type

		Assert.assertNotNull(_model.getMethod("ca.uwaterloo.cs.se.bench.simple.SimpleClass.a1()"));
		Assert.assertNotNull(_model.getMethod("ca.uwaterloo.cs.se.bench.simple.SimpleClass.a2()"));
		Assert.assertNotNull(_model.getMethod("ca.uwaterloo.cs.se.bench.simple.SimpleClass.b1()"));
		Assert.assertNotNull(_model.getMethod("ca.uwaterloo.cs.se.bench.simple.SimpleClass.b2()"));
		Assert.assertNotNull(_model.getMethod("ca.uwaterloo.cs.se.bench.simple.SimpleClass.f1()"));
		Assert.assertNotNull(_model.getMethod("ca.uwaterloo.cs.se.bench.simple.SimpleClass.f2(java.util.Collection)"));
	}

	@Test
	public void parseSimpleClassFieldA() {
		ClassElement ce = _model.getClass("ca.uwaterloo.cs.se.bench.simple.SimpleClass");
		Assert.assertNotNull(ce);

		FieldElement fe = _model.getField("ca.uwaterloo.cs.se.bench.simple.SimpleClass.fieldA");
		Assert.assertNotNull(fe);
		Assert.assertEquals("java.lang.String", fe.getType().getId());
	}

	@Test
	public void parseSimpleClassA1() {
		MethodElement me = _model.getMethod("ca.uwaterloo.cs.se.bench.simple.SimpleClass.a1()");
		Assert.assertNotNull(me);

		MethodElement target = _model.getMethod("ca.uwaterloo.cs.se.bench.simple.SimpleClass.a2()");
		Assert.assertNotNull(target);

		Assert.assertEquals(target, me.getCalls().iterator().next());
	}

	@Test
	public void parseSimpleClassB2() {
		MethodElement me = _model.getMethod("ca.uwaterloo.cs.se.bench.simple.SimpleClass.b2()");
		Assert.assertNotNull(me);

		MethodReturnElement retType = new MethodReturnElement(_model.getClass("java.util.Vector"));

		Assert.assertEquals(retType, me.getReturnElement());
	}

	@Test
	public void parseSimpleClassF2() {
		MethodElement me = _model.getMethod("ca.uwaterloo.cs.se.bench.simple.SimpleClass.f2(java.util.Collection)");
		Assert.assertNotNull(me);

		MethodParamElement param = new MethodParamElement(_model.getClass("java.util.Collection"), 0);
		Assert.assertNotNull(param);

		Assert.assertEquals(param, me.getParameters().iterator().next());
	}

	@Test
	public void parseSimpleClassN0() {
		MethodElement me = _model.getMethod("ca.uwaterloo.cs.se.bench.simple.SimpleClass.n0()");
		Assert.assertNotNull(me);

		FieldElement target = _model.getField("ca.uwaterloo.cs.se.bench.simple.SimpleClass.fieldA");
		Assert.assertNotNull(target);
		Assert.assertEquals(target, me.getReferences().iterator().next());
	}

}
