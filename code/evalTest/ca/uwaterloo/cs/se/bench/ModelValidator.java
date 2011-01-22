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
import ca.uwaterloo.cs.se.bench.model.io.XMLReaderDynamicTracer;

/**
 * Test SimpleClass
 * 
 * @author rtholmes
 * 
 */
public class ModelValidator {

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
	public void parseInhInterface() {
		ClassElement ce = _staticModel.getClass(Ids.InhInterface);
		Assert.assertNotNull(ce);

		Assert.assertTrue(ce.isInterface());

		Assert.assertTrue(ce.isAbstract());

		Assert.assertEquals(0, ce.getParents().size());
		Assert.assertEquals(0, ce.getFields().size());
		Assert.assertEquals(3, ce.getMethods().size());
	}

	@Test
	public void parseInhAbstractClass() {
		ClassElement ce = _staticModel.getClass(Ids.InhAbstractClass);
		Assert.assertNotNull(ce);

		Assert.assertFalse(ce.isInterface());
		Assert.assertTrue(ce.isAbstract());

		Assert.assertEquals(1, ce.getParents().size());
		Assert.assertEquals(0, ce.getFields().size());
		Assert.assertEquals(5, ce.getMethods().size());

		Assert.assertEquals(_staticModel.getClass(Ids.InhInterface), ce.getParents().iterator().next());
	}

	@Test
	public void parseInhClassA() {
		ClassElement ce = _staticModel.getClass(Ids.InhClassA);
		Assert.assertNotNull(ce);

		Assert.assertFalse(ce.isInterface());
		Assert.assertFalse(ce.isAbstract());

		Assert.assertEquals(1, ce.getParents().size());
		Assert.assertEquals(0, ce.getFields().size());
		Assert.assertEquals(4, ce.getMethods().size());

		Assert.assertEquals(_staticModel.getClass(Ids.InhAbstractClass), ce.getParents().iterator().next());
	}

	@Test
	public void parseCollection() {
		ClassElement ce = _staticModel.getClass(Ids.Collection);
		Assert.assertNotNull(ce);

		Assert.assertTrue(ce.isExternal());

		Assert.assertEquals(0, ce.getParents().size());
		Assert.assertEquals(0, ce.getFields().size());
		Assert.assertEquals(0, ce.getMethods().size());
	}

	@Test
	public void parseVector() {
		ClassElement ce = _staticModel.getClass(Ids.Vector);
		Assert.assertNotNull(ce);

		Assert.assertTrue(ce.isExternal());

		Assert.assertEquals(0, ce.getParents().size());
		Assert.assertEquals(0, ce.getFields().size());
		Assert.assertEquals(2, ce.getMethods().size()); // Vector(), add(Object)

		Assert.assertEquals(Ids.Vector_init, ce.getMethods().iterator().next().getId());
	}

	@Test
	public void parseString() {
		ClassElement ce = _staticModel.getClass(Ids.String);
		Assert.assertNotNull(ce);

		Assert.assertTrue(ce.isExternal());

		Assert.assertEquals(0, ce.getParents().size());
		Assert.assertEquals(0, ce.getFields().size());
		Assert.assertEquals(1, ce.getMethods().size()); // compareTo
	}

	@Test
	public void parseV() {
		ClassElement ce = _staticModel.getClass("void");
		Assert.assertNotNull(ce);

		Assert.assertTrue(ce.isExternal());

		Assert.assertEquals(0, ce.getParents().size());
		Assert.assertEquals(0, ce.getFields().size());
		Assert.assertEquals(0, ce.getMethods().size());
	}

	@Test
	public void parseSimpleClassStructure() {
		ClassElement ce = _staticModel.getClass(Ids.SimpleClass);
		Assert.assertNotNull(ce);

		Assert.assertFalse(ce.isExternal());

		Assert.assertEquals(0, ce.getParents().size());
		Assert.assertEquals(1, ce.getFields().size());
		Assert.assertEquals(28, ce.getMethods().size());

		Assert.assertEquals(Ids.SimpleClass_fieldA, ce.getFields().iterator().next().getId());

		Assert.assertTrue(_staticModel.hasMethod(Ids.SimpleClass_a1));
		Assert.assertTrue(_staticModel.hasMethod(Ids.SimpleClass_a2));
		Assert.assertTrue(_staticModel.hasMethod(Ids.SimpleClass_b1));
		Assert.assertTrue(_staticModel.hasMethod(Ids.SimpleClass_b2));
		Assert.assertTrue(_staticModel.hasMethod(Ids.SimpleClass_c1));
		Assert.assertTrue(_staticModel.hasMethod(Ids.SimpleClass_c2));
		Assert.assertTrue(_staticModel.hasMethod(Ids.SimpleClass_d1));
		Assert.assertTrue(_staticModel.hasMethod(Ids.SimpleClass_d2));
		Assert.assertTrue(_staticModel.hasMethod(Ids.SimpleClass_e1));
		Assert.assertTrue(_staticModel.hasMethod(Ids.SimpleClass_e2));
		Assert.assertTrue(_staticModel.hasMethod(Ids.SimpleClass_f1));
		Assert.assertTrue(_staticModel.hasMethod(Ids.SimpleClass_f2));
		Assert.assertTrue(_staticModel.hasMethod(Ids.SimpleClass_g1));
		Assert.assertTrue(_staticModel.hasMethod(Ids.SimpleClass_g2));

		Assert.assertTrue(_staticModel.hasMethod(Ids.SimpleClass_h1));
		Assert.assertTrue(_staticModel.hasMethod(Ids.SimpleClass_h2));
		Assert.assertTrue(_staticModel.hasMethod(Ids.SimpleClass_i1));
		Assert.assertTrue(_staticModel.hasMethod(Ids.SimpleClass_i2));
		Assert.assertTrue(_staticModel.hasMethod(Ids.SimpleClass_j1));
		Assert.assertTrue(_staticModel.hasMethod(Ids.SimpleClass_j2));
		Assert.assertTrue(_staticModel.hasMethod(Ids.SimpleClass_l1));
		Assert.assertTrue(_staticModel.hasMethod(Ids.SimpleClass_l2));
		Assert.assertTrue(_staticModel.hasMethod(Ids.SimpleClass_m1));
		Assert.assertTrue(_staticModel.hasMethod(Ids.SimpleClass_m2));
		Assert.assertTrue(_staticModel.hasMethod(Ids.SimpleClass_n0));
	}

	@Test
	public void parseSimpleClassFieldA() {
		ClassElement ce = _staticModel.getClass(Ids.SimpleClass);
		Assert.assertNotNull(ce);

		FieldElement fe = _staticModel.getField(Ids.SimpleClass_fieldA);
		Assert.assertNotNull(fe);
		Assert.assertEquals(Ids.String, fe.getType().getId());
	}

	// Done
	@Test
	public void testSimpleClass_a1_a2() {
		// static
		MethodElement s_source = _staticModel.getMethod(Ids.SimpleClass_a1);
		MethodElement s_target = _staticModel.getMethod(Ids.SimpleClass_a2);

		Assert.assertNotNull(s_source);
		Assert.assertNotNull(s_target);

		Assert.assertEquals(1, s_source.getCalls().size());
		Assert.assertEquals(0, s_target.getCalls().size());

		Assert.assertTrue(s_source.getCalls().contains(s_target));

		// dynamic
		MethodElement d_source = _dynamicModel.getMethod(Ids.SimpleClass_a1);
		MethodElement d_target = _dynamicModel.getMethod(Ids.SimpleClass_a2);

		Assert.assertNotNull(d_source);
		Assert.assertNotNull(d_target);

		Assert.assertEquals(1, d_source.getCalls().size());
		Assert.assertEquals(0, d_target.getCalls().size());
		Assert.assertTrue(d_source.getCalls().contains(d_target));
	}

	@Test
	public void parseSimpleClassB2() {
		MethodElement me = _staticModel.getMethod(Ids.SimpleClass_b2);
		Assert.assertNotNull(me);

		MethodReturnElement retType = new MethodReturnElement(_staticModel.getClass(Ids.Vector));

		Assert.assertEquals(retType, me.getReturnElement());
	}

	@Test
	public void parseSimpleClassF2() {
		MethodElement me = _staticModel.getMethod(Ids.SimpleClass_f2);
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
		MethodElement me = _staticModel.getMethod(Ids.SimpleClass_n0);
		Assert.assertNotNull(me);

		FieldElement target = _staticModel.getField(Ids.SimpleClass_fieldA);
		Assert.assertNotNull(target);
		Assert.assertEquals(target, me.getReferences().iterator().next());
	}

}
