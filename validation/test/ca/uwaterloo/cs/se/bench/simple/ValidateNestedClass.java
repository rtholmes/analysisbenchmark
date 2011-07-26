package ca.uwaterloo.cs.se.bench.simple;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;

import com.google.common.collect.Iterators;

import ca.uwaterloo.cs.se.inconsistency.core.model2.ClassElement;
import ca.uwaterloo.cs.se.inconsistency.core.model2.FieldElement;
import ca.uwaterloo.cs.se.inconsistency.core.model2.MethodElement;
import ca.uwaterloo.cs.se.inconsistency.core.model2.MethodParamElement;

/**
 * Test SimpleClass
 * 
 * @author koshikoj
 * 
 */
public class ValidateNestedClass extends AbstractValidation {

	// Done
	@Test
	public void checkClass() {
		// static
		ClassElement s_ce = _staticModel.getClass(Ids.NestedClass);
		Assert.assertNotNull(s_ce);

		Assert.assertFalse(s_ce.isExternal());
		Assert.assertFalse(s_ce.isAbstract());
		Assert.assertEquals(0, s_ce.getParents().size());

		// dynamic (nesting isn't captured by the tracer)
		// ClassElement d_ce = _dynamicModel.getClass(Ids.SimpleClass);
		// Assert.assertNotNull(d_ce);

		Assert.assertTrue(_staticModel.hasClass(Ids.NestedClass_InnerClass));
		ClassElement s_ct = _staticModel.getClass(Ids.NestedClass_InnerClass);
		Assert.assertNotNull(s_ct);

		Assert.assertFalse(s_ct.isExternal());
		Assert.assertFalse(s_ct.isAbstract());
		Assert.assertEquals(0, s_ct.getParents().size());

		// dynamic (nesting isn't captured by the tracer)
		// ClassElement d_ce = _dynamicModel.getClass(Ids.SimpleClass);
		// Assert.assertNotNull(d_ce);

		Assert.assertTrue(_staticModel.hasClass(Ids.NestedClass_InnerInnerClass));
		ClassElement s_cr = _staticModel.getClass(Ids.NestedClass_InnerInnerClass);
		Assert.assertNotNull(s_cr);

		Assert.assertFalse(s_cr.isExternal());
		Assert.assertFalse(s_cr.isAbstract());
		Assert.assertEquals(0, s_cr.getParents().size());

		// dynamic (nesting isn't captured by the tracer)
		// ClassElement d_ce = _dynamicModel.getClass(Ids.SimpleClass);
		// Assert.assertNotNull(d_ce);

	}

	// Done
	@Test
	public void checkFields() {
		// static
		Assert.assertTrue(_staticModel.hasField(Ids.NestedClass_nestedString));
		Assert.assertNotNull(_staticModel.getField(Ids.NestedClass_nestedString));
		Assert.assertEquals(Ids.NestedClass_nestedString, _staticModel.getField(Ids.NestedClass_nestedString).getId());

		Assert.assertTrue(_staticModel.hasField(Ids.NestedClass_nestedVector));
		Assert.assertNotNull(_staticModel.getField(Ids.NestedClass_nestedVector));
		Assert.assertEquals(Ids.NestedClass_nestedVector, _staticModel.getField(Ids.NestedClass_nestedVector).getId());

		Assert.assertTrue(_staticModel.hasField(Ids.NestedClass_nestedStringVector));
		Assert.assertNotNull(_staticModel.getField(Ids.NestedClass_nestedStringVector));
		Assert.assertEquals(Ids.NestedClass_nestedStringVector, _staticModel.getField(Ids.NestedClass_nestedStringVector).getId());

		Assert.assertTrue(_staticModel.hasField(Ids.NestedClass_nestedInitializedStringVector));
		Assert.assertNotNull(_staticModel.getField(Ids.NestedClass_nestedInitializedStringVector));
		Assert.assertEquals(Ids.NestedClass_nestedInitializedStringVector,
				_staticModel.getField(Ids.NestedClass_nestedInitializedStringVector).getId());

		ClassElement s_ce = _staticModel.getClass(Ids.NestedClass);
		Assert.assertEquals(4, s_ce.getFields().size());
		Assert.assertTrue(Iterators.contains(s_ce.getFields().iterator(), _staticModel.getField(Ids.NestedClass_nestedString)));

		ClassElement s_ct = _staticModel.getClass(Ids.NestedClass_InnerClass);
		Assert.assertEquals(1, s_ct.getFields().size());

		ClassElement s_cr = _staticModel.getClass(Ids.NestedClass_InnerInnerClass);
		Assert.assertEquals(1, s_cr.getFields().size());

		// dynamic (commented out because we're not currently tracing field
		// references)
		// Assert.assertTrue(_dynamicModel.hasField(Ids.SimpleClass_fieldA));
		// Assert.assertNotNull(_dynamicModel.getField(Ids.SimpleClass_fieldA));
		// Assert.assertEquals(Ids.SimpleClass_fieldA,
		// _dynamicModel.getField(Ids.SimpleClass_fieldA).getId());
	}

	// Done
	@Test
	public void checkMethods() {
		// static
		ClassElement s_ce = _staticModel.getClass(Ids.NestedClass);
		Assert.assertNotNull(s_ce);
		Assert.assertEquals(4, s_ce.getMethods().size());

		Assert.assertTrue(_staticModel.hasMethod(Ids.NestedClass_init));
		Assert.assertTrue(_staticModel.hasMethod(Ids.NestedClass_nestedMethodA));
		Assert.assertTrue(_staticModel.hasMethod(Ids.NestedClass_nestedMethodB));
		Assert.assertTrue(_staticModel.hasMethod(Ids.NestedClass_nestedMethodC));
		Assert.assertTrue(_staticModel.hasMethod(Ids.NestedClass_innerMethodA));
		Assert.assertTrue(_staticModel.hasMethod(Ids.NestedClass_innerMethodB));
		Assert.assertTrue(_staticModel.hasMethod(Ids.NestedClass_innerMethodC));
		Assert.assertTrue(_staticModel.hasMethod(Ids.NestedClass_innerinnerMethodA));
		Assert.assertTrue(_staticModel.hasMethod(Ids.NestedClass_innerinnerMethodB));
		Assert.assertTrue(_staticModel.hasMethod(Ids.NestedClass_innerinnerMethodC));

		// dynamic
		// aggregates not checked because tracer doesn't record containment
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.NestedClass_init));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.NestedClass_nestedMethodA));
		// B isn't called in the test suite
		// Assert.assertTrue(_dynamicModel.hasMethod(Ids.NestedClass_nestedMethodB));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.NestedClass_nestedMethodC));

		// dynamic
		// aggregates not checked because tracer doesn't record containment
		/*
		 * A not called Assert.assertTrue(_dynamicModel.hasMethod(Ids.NestedClass_innerinit)); Assert.assertTrue(_dynamicModel
		 * .hasMethod(Ids.NestedClass_innerMethodA));
		 */

		Assert.assertTrue(_dynamicModel.hasMethod(Ids.NestedClass_innerMethodB));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.NestedClass_innerMethodC));

		// dynamic
		// aggregates not checked because tracer doesn't record containment
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.NestedClass_innerinnerinit));
		/*
		 * A not called Assert.assertTrue(_dynamicModel .hasMethod(Ids.NestedClass_innerinnerMethodA));
		 */
		// B isn't called in the test suite
		// Assert.assertTrue(_dynamicModel.hasMethod(Ids.NestedClass_nestedMethodB));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.NestedClass_innerinnerMethodC));

	}

	// Done
	@Test
	public void test_nest() {
		// static

		// method a properties
		MethodElement s_a = _staticModel.getMethod(Ids.NestedClass_nestedMethodA);
		Assert.assertNotNull(s_a);
		Assert.assertEquals(Ids.Prim_void, s_a.getReturnElement().getType().getId());
		Assert.assertEquals(0, s_a.getParameters().size());

		// method b properties
		MethodElement s_b = _staticModel.getMethod(Ids.NestedClass_nestedMethodB);
		Assert.assertNotNull(s_b);
		Assert.assertEquals(s_b.getReturnElement().getType().getId(), Ids.Prim_void);
		Assert.assertEquals(0, s_b.getParameters().size());

		// method c properties
		MethodElement s_c = _staticModel.getMethod(Ids.NestedClass_nestedMethodC);
		Assert.assertNotNull(s_c);
		Assert.assertEquals(s_c.getReturnElement().getType().getId(), Ids.Prim_void);
		Assert.assertEquals(0, s_c.getParameters().size());

		// static call
		Assert.assertEquals(1, s_a.getCalls().size());
		Assert.assertEquals(0, s_b.getCalls().size());
		Assert.assertEquals(0, s_c.getCalls().size());

		// dynamic
		// a
		MethodElement d_a = _dynamicModel.getMethod(Ids.NestedClass_nestedMethodA);
		Assert.assertNotNull(d_a);

		/*
		 * b is not called MethodElement d_b = _dynamicModel.getMethod(Ids.NestedClass_nestedMethodB); Assert.assertNotNull(d_b);
		 */
		// c
		MethodElement d_c = _dynamicModel.getMethod(Ids.NestedClass_nestedMethodC);
		Assert.assertNotNull(d_c);

		// a1 -> a2 dynamic call
		Assert.assertEquals(1, d_a.getCalls().size());
		// Assert.assertEquals(0, d_b.getCalls().size());
		Assert.assertEquals(0, d_c.getCalls().size());

		// Assert.assertTrue(d_a1.getCalls().contains(d_a2));
	}

	// Done
	@Test
	public void test_inner() {
		// static

		// method a properties
		MethodElement s_a = _staticModel.getMethod(Ids.NestedClass_innerMethodA);
		Assert.assertNotNull(s_a);
		Assert.assertEquals(Ids.Prim_void, s_a.getReturnElement().getType().getId());
		Assert.assertEquals(0, s_a.getParameters().size());

		// method b properties
		MethodElement s_b = _staticModel.getMethod(Ids.NestedClass_innerMethodB);
		Assert.assertNotNull(s_b);
		Assert.assertEquals(s_b.getReturnElement().getType().getId(), Ids.Prim_void);
		Assert.assertEquals(0, s_b.getParameters().size());

		// method c properties
		MethodElement s_c = _staticModel.getMethod(Ids.NestedClass_innerMethodC);
		Assert.assertNotNull(s_c);
		Assert.assertEquals(s_c.getReturnElement().getType().getId(), Ids.Prim_void);
		Assert.assertEquals(0, s_c.getParameters().size());

		// static call
		Assert.assertEquals(1, s_a.getCalls().size());
		Assert.assertEquals(0, s_b.getCalls().size());
		Assert.assertEquals(1, s_c.getCalls().size());

		// dynamic
		/*
		 * a is not called MethodElement d_a = _dynamicModel.getMethod(Ids.NestedClass_innerMethodA); Assert.assertNotNull(d_a);
		 */

		MethodElement d_b = _dynamicModel.getMethod(Ids.NestedClass_innerMethodB);
		Assert.assertNotNull(d_b);

		// c
		MethodElement d_c = _dynamicModel.getMethod(Ids.NestedClass_innerMethodC);
		Assert.assertNotNull(d_c);

		// a1 -> a2 dynamic call
		// Assert.assertEquals(1, d_a.getCalls().size());
		Assert.assertEquals(0, d_b.getCalls().size());
		Assert.assertEquals(1, d_c.getCalls().size());

		// Assert.assertTrue(d_a1.getCalls().contains(d_a2));
	}

	@Test
	public void test_innerinner() {
		// static

		// method a properties
		MethodElement s_a = _staticModel.getMethod(Ids.NestedClass_innerinnerMethodA);
		Assert.assertNotNull(s_a);
		Assert.assertEquals(Ids.Prim_void, s_a.getReturnElement().getType().getId());
		Assert.assertEquals(0, s_a.getParameters().size());

		// method b properties
		MethodElement s_b = _staticModel.getMethod(Ids.NestedClass_innerinnerMethodB);
		Assert.assertNotNull(s_b);
		Assert.assertEquals(s_b.getReturnElement().getType().getId(), Ids.Prim_void);
		Assert.assertEquals(0, s_b.getParameters().size());

		// method c properties
		MethodElement s_c = _staticModel.getMethod(Ids.NestedClass_innerinnerMethodC);
		Assert.assertNotNull(s_c);
		Assert.assertEquals(s_c.getReturnElement().getType().getId(), Ids.Prim_void);
		Assert.assertEquals(0, s_c.getParameters().size());

		// static call
		Assert.assertEquals(1, s_a.getCalls().size());
		Assert.assertEquals(1, s_b.getCalls().size());
		Assert.assertEquals(1, s_c.getCalls().size());

		// dynamic
		/*
		 * a is not called MethodElement d_a = _dynamicModel.getMethod(Ids.NestedClass_innerMethodA); Assert.assertNotNull(d_a);
		 * 
		 * b not called MethodElement d_b = _dynamicModel.getMethod(Ids.NestedClass_innerinnerMethodB); Assert.assertNotNull(d_b);
		 */
		// c
		MethodElement d_c = _dynamicModel.getMethod(Ids.NestedClass_innerinnerMethodC);
		Assert.assertNotNull(d_c);

		// a1 -> a2 dynamic call
		// Assert.assertEquals(1, d_a.getCalls().size());
		// Assert.assertEquals(0, d_b.getCalls().size());
		Assert.assertEquals(1, d_c.getCalls().size());

		// Assert.assertTrue(d_a1.getCalls().contains(d_a2));
	}
}
