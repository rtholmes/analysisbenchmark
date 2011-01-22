package ca.uwaterloo.cs.se.bench;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.uwaterloo.cs.se.bench.model.ClassElement;
import ca.uwaterloo.cs.se.bench.model.FieldElement;
import ca.uwaterloo.cs.se.bench.model.MethodElement;
import ca.uwaterloo.cs.se.bench.model.MethodReturnElement;
import ca.uwaterloo.cs.se.bench.model.Model;
import ca.uwaterloo.cs.se.bench.model.io.XMLReaderDependencyFinder;

/**
 * Synthetic test; essentially makes sure the eval code is working separate from
 * the suite that will actually test the model.
 * 
 * @author rtholmes
 * 
 */
public class StaticModelValidator {

	protected Model _model;

	private final String fName = "report/static/static_latest.xml";

	@Before
	public void initModel() {

		XMLReaderDependencyFinder xmlrdf = new XMLReaderDependencyFinder(fName);
		Assert.assertNotNull(xmlrdf);

		_model = xmlrdf.parseModel();

		Assert.assertNotNull(_model);
	}

	@BeforeClass
	public static void beforeClass() {
		XMLReaderDependencyFinder.startLog4J(true);
	}

	@Test
	public void parseInhInterface() {
		ClassElement ce = _model.getClass(Ids.InhInterface);
		Assert.assertNotNull(ce);

		Assert.assertTrue(ce.isInterface());

		Assert.assertTrue(ce.isAbstract()); // depfind_uw #15: InhInterface
											// shouldn't be abstract

		Assert.assertEquals(0, ce.getParents().size());
		Assert.assertEquals(0, ce.getFields().size());
		Assert.assertEquals(3, ce.getMethods().size());
	}

	@Test
	public void parseInhAbstractClass() {
		ClassElement ce = _model.getClass(Ids.InhAbstractClass);
		Assert.assertNotNull(ce);

		Assert.assertFalse(ce.isInterface());
		Assert.assertTrue(ce.isAbstract());

		Assert.assertEquals(1, ce.getParents().size());
		Assert.assertEquals(0, ce.getFields().size());
		Assert.assertEquals(5, ce.getMethods().size());

		Assert.assertEquals(_model.getClass(Ids.InhInterface), ce.getParents().iterator().next());
	}

	@Test
	public void parseInhClassA() {
		ClassElement ce = _model.getClass(Ids.InhClassA);
		Assert.assertNotNull(ce);

		Assert.assertFalse(ce.isInterface());
		Assert.assertFalse(ce.isAbstract());

		Assert.assertEquals(1, ce.getParents().size());
		Assert.assertEquals(0, ce.getFields().size());
		Assert.assertEquals(4, ce.getMethods().size());

		Assert.assertEquals(_model.getClass(Ids.InhAbstractClass), ce.getParents().iterator().next());
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
		Assert.assertEquals(2, ce.getMethods().size()); // Vector(), add(Object)

		Assert.assertEquals(Ids.Vector_init, ce.getMethods().iterator().next().getId());
	}

	@Test
	public void parseString() {
		ClassElement ce = _model.getClass(Ids.String);
		Assert.assertNotNull(ce);

		Assert.assertTrue(ce.isExternal());

		Assert.assertEquals(0, ce.getParents().size());
		Assert.assertEquals(0, ce.getFields().size());
		Assert.assertEquals(1, ce.getMethods().size()); // compareTo
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
		Assert.assertEquals(28, ce.getMethods().size());

		Assert.assertEquals(Ids.SimpleClass_fieldA, ce.getFields().iterator().next().getId());

		// TODO: ensure method is attached to type
		Assert.assertTrue(_model.hasMethod(Ids.SimpleClass_a1));
		Assert.assertTrue(_model.hasMethod(Ids.SimpleClass_a2));
		Assert.assertTrue(_model.hasMethod(Ids.SimpleClass_b1));
		Assert.assertTrue(_model.hasMethod(Ids.SimpleClass_b2));
		Assert.assertTrue(_model.hasMethod(Ids.SimpleClass_c1));
		Assert.assertTrue(_model.hasMethod(Ids.SimpleClass_c2));
		Assert.assertTrue(_model.hasMethod(Ids.SimpleClass_d1));
		Assert.assertTrue(_model.hasMethod(Ids.SimpleClass_d2));
		Assert.assertTrue(_model.hasMethod(Ids.SimpleClass_e1));
		Assert.assertTrue(_model.hasMethod(Ids.SimpleClass_e2));
		Assert.assertTrue(_model.hasMethod(Ids.SimpleClass_f1));
		Assert.assertTrue(_model.hasMethod(Ids.SimpleClass_f2));
		Assert.assertTrue(_model.hasMethod(Ids.SimpleClass_g1));
		Assert.assertTrue(_model.hasMethod(Ids.SimpleClass_g2));

		Assert.assertTrue(_model.hasMethod(Ids.SimpleClass_h1));
		Assert.assertTrue(_model.hasMethod(Ids.SimpleClass_h2));
		Assert.assertTrue(_model.hasMethod(Ids.SimpleClass_i1));
		Assert.assertTrue(_model.hasMethod(Ids.SimpleClass_i2));
		Assert.assertTrue(_model.hasMethod(Ids.SimpleClass_j1));
		Assert.assertTrue(_model.hasMethod(Ids.SimpleClass_j2));
		Assert.assertTrue(_model.hasMethod(Ids.SimpleClass_l1));
		Assert.assertTrue(_model.hasMethod(Ids.SimpleClass_l2));
		Assert.assertTrue(_model.hasMethod(Ids.SimpleClass_m1));
		Assert.assertTrue(_model.hasMethod(Ids.SimpleClass_m2));
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

		// XXX: parameters not working yet
		// MethodParamElement param = new
		// MethodParamElement(_model.getClass("java.util.Collection"), 0);
		// Assert.assertNotNull(param);
		//
		// Assert.assertEquals(param, me.getParameters().iterator().next());
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
