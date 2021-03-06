package ca.uwaterloo.cs.se.bench.model.io;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.uwaterloo.cs.se.bench.simple.Ids;
import ca.uwaterloo.cs.se.inconsistency.core.model2.ClassElement;
import ca.uwaterloo.cs.se.inconsistency.core.model2.FieldElement;
import ca.uwaterloo.cs.se.inconsistency.core.model2.MethodElement;
import ca.uwaterloo.cs.se.inconsistency.core.model2.MethodParamElement;
import ca.uwaterloo.cs.se.inconsistency.core.model2.MethodReturnElement;
import ca.uwaterloo.cs.se.inconsistency.core.model2.Model;

/**
 * Synthetic test; essentially makes sure the eval code is working separate from the suite that will actually test the model.
 * 
 * @author rtholmes
 * 
 */
public class SyntheticModelTest {

	private final String fName = "testResources/static_synthetic.xml";
	private Model _model;

	@BeforeClass
	public static void beforeClass() {
		// NOTE: start logging
	}

	@Before
	public void initModel() {
		// XXX: this needs to be updated to the new model / Model2XML format

		// XMLReaderDependencyFinder xmlrdf = new XMLReaderDependencyFinder(fName);
		_model = null; // xmlrdf.parseModel();

		Assert.assertNotNull(_model);
	}

	@Test
	public void parseInhInterface() {
		ClassElement ce = _model.getClass("ca.uwaterloo.cs.se.bench.simple.InhInterface");
		Assert.assertNotNull(ce);

		Assert.assertTrue(ce.isInterface());
		Assert.assertTrue(ce.isAbstract());

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
		ClassElement ce = _model.getClass(Ids.Collection);
		Assert.assertNotNull(ce);

		Assert.assertTrue(ce.isExternal());

		Assert.assertEquals(0, ce.getParents().size());
		Assert.assertEquals(0, ce.getFields().size());
		Assert.assertEquals(0, ce.getMethods().size());
	}

	@Test
	public void parseVector() {
		ClassElement ce = _model.getClass(Ids.Vector);
		Assert.assertNotNull(ce);

		Assert.assertTrue(ce.isExternal());

		Assert.assertEquals(0, ce.getParents().size());
		Assert.assertEquals(0, ce.getFields().size());
		Assert.assertEquals(1, ce.getMethods().size());

		Assert.assertFalse(ce.getMethods().isEmpty());
		Assert.assertEquals(Ids.Vector_init, ce.getMethods().iterator().next().getId());
	}

	@Test
	public void parseString() {
		ClassElement ce = _model.getClass(Ids.String);
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
		ClassElement ce = _model.getClass(Ids.SimpleClass);
		Assert.assertNotNull(ce);

		Assert.assertFalse(ce.isExternal());

		Assert.assertEquals(0, ce.getParents().size());
		Assert.assertEquals(1, ce.getFields().size());
		Assert.assertEquals(7, ce.getMethods().size());

		Assert.assertEquals(Ids.SimpleClass_fieldA, ce.getFields().iterator().next().getId());

		// TODO: ensure method is attached to type

		Assert.assertTrue(_model.hasMethod(Ids.SimpleClass_a1));
		Assert.assertTrue(_model.hasMethod(Ids.SimpleClass_a2));
		Assert.assertTrue(_model.hasMethod(Ids.SimpleClass_b1));
		Assert.assertTrue(_model.hasMethod(Ids.SimpleClass_b2));
		Assert.assertTrue(_model.hasMethod(Ids.SimpleClass_f1));
		Assert.assertTrue(_model.hasMethod(Ids.SimpleClass_f2));
		Assert.assertTrue(_model.hasMethod(Ids.SimpleClass_n0));
	}

	@Test
	public void parseSimpleClassFieldA() {
		ClassElement ce = _model.getClass(Ids.SimpleClass);
		Assert.assertNotNull(ce);

		FieldElement fe = _model.getField(Ids.SimpleClass_fieldA);
		Assert.assertNotNull(fe);
		Assert.assertEquals(Ids.String, fe.getType().getId());
	}

	@Test
	public void parseSimpleClassA1() {
		MethodElement me = _model.getMethod(Ids.SimpleClass_a1);
		Assert.assertNotNull(me);

		MethodElement target = _model.getMethod(Ids.SimpleClass_a2);
		Assert.assertNotNull(target);

		Assert.assertEquals(target, me.getCalls().iterator().next());
	}

	@Test
	public void parseSimpleClassB2() {
		MethodElement me = _model.getMethod(Ids.SimpleClass_b2);
		Assert.assertNotNull(me);

		MethodReturnElement retType = new MethodReturnElement(_model.getClass(Ids.Vector));

		Assert.assertEquals(retType, me.getReturnElement());
	}

	@Test
	public void parseSimpleClassF2() {
		MethodElement me = _model.getMethod(Ids.SimpleClass_f2);
		Assert.assertNotNull(me);

		MethodParamElement param = new MethodParamElement(_model.getClass(Ids.Collection), 0);
		Assert.assertNotNull(param);

		Assert.assertEquals(param, me.getParameters().iterator().next());

	}

	@Test
	public void parseSimpleClassN0() {
		MethodElement me = _model.getMethod(Ids.SimpleClass_n0);
		Assert.assertNotNull(me);

		FieldElement target = _model.getField(Ids.SimpleClass_fieldA);
		Assert.assertNotNull(target);
		Assert.assertEquals(target, me.getReferences().iterator().next());
	}

}
