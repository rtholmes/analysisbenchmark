package ca.uwaterloo.cs.se.bench;

import junit.framework.Assert;

import org.junit.Test;

import ca.uwaterloo.cs.se.bench.model.ClassElement;
import ca.uwaterloo.cs.se.bench.model.FieldElement;
import ca.uwaterloo.cs.se.bench.model.MethodElement;
import ca.uwaterloo.cs.se.bench.model.MethodReturnElement;

import com.google.common.collect.Iterators;

/**
 * Test SimpleClass
 * 
 * @author rtholmes
 * 
 */
public class ValidateSimpleClass extends AbstractValidation {

	@Test
	public void checkClass() {
		// static
		ClassElement s_ce = _staticModel.getClass(Ids.SimpleClass);
		Assert.assertNotNull(s_ce);

		Assert.assertFalse(s_ce.isExternal());
		Assert.assertFalse(s_ce.isAbstract());
		Assert.assertEquals(0, s_ce.getParents().size());

		// dynamic (nesting isn't captured by the tracer)
		// ClassElement d_ce = _dynamicModel.getClass(Ids.SimpleClass);
		// Assert.assertNotNull(d_ce);
	}

	@Test
	public void checkFields() {
		// static
		Assert.assertTrue(_staticModel.hasField(Ids.SimpleClass_fieldA));
		Assert.assertNotNull(_staticModel.getField(Ids.SimpleClass_fieldA));
		Assert.assertEquals(Ids.SimpleClass_fieldA, _staticModel.getField(Ids.SimpleClass_fieldA).getId());

		ClassElement s_ce = _staticModel.getClass(Ids.SimpleClass);
		Assert.assertEquals(1, s_ce.getFields().size());
		Assert.assertTrue(Iterators.contains(s_ce.getFields().iterator(), _staticModel.getField(Ids.SimpleClass_fieldA)));

		// dynamic (commented out because we're not currently tracing field references)
		// Assert.assertTrue(_dynamicModel.hasField(Ids.SimpleClass_fieldA));
		// Assert.assertNotNull(_dynamicModel.getField(Ids.SimpleClass_fieldA));
		// Assert.assertEquals(Ids.SimpleClass_fieldA, _dynamicModel.getField(Ids.SimpleClass_fieldA).getId());
	}

	@Test
	public void checkMethods() {
		// static
		ClassElement s_ce = _staticModel.getClass(Ids.SimpleClass);
		Assert.assertNotNull(s_ce);
		Assert.assertEquals(28, s_ce.getMethods().size());

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

		// dynamic
		// aggregates not checked because tracer doesn't record containment
		// Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_a1));
		// Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_a2));
		// Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_b1));
		// Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_b2));
		// Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_c1));
		// Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_c2));
		// Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_d1));
		// Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_d2));
		// Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_e1));
		// Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_e2));
		// Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_f1));
		// Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_f2));
		// Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_g1));
		// Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_g2));
		// Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_h1));
		// Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_h2));
		// Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_i1));
		// Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_i2));
		// Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_j1));
		// Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_j2));
		// Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_l1));
		// Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_l2));
		// Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_m1));
		// Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_m2));
		// Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_n0));
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
	public void parseSimpleClassFieldA() {
		ClassElement ce = _staticModel.getClass(Ids.SimpleClass);
		Assert.assertNotNull(ce);

		FieldElement fe = _staticModel.getField(Ids.SimpleClass_fieldA);
		Assert.assertNotNull(fe);
		Assert.assertEquals(Ids.String, fe.getType().getId());
	}

	@Test
	public void parseSimpleClassN0() {
		MethodElement me = _staticModel.getMethod(Ids.SimpleClass_n0);
		Assert.assertNotNull(me);

		FieldElement target = _staticModel.getField(Ids.SimpleClass_fieldA);
		Assert.assertNotNull(target);
		Assert.assertEquals(target, me.getReferences().iterator().next());
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

}
