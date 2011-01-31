package ca.uwaterloo.cs.se.bench.simple;

import java.util.Collection;
import java.util.List;
import java.util.Vector;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import ca.uwaterloo.cs.se.bench.model.ClassElement;
import ca.uwaterloo.cs.se.bench.model.FieldElement;
import ca.uwaterloo.cs.se.bench.model.MethodElement;
import ca.uwaterloo.cs.se.bench.model.MethodParamElement;

import com.google.common.collect.Iterators;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.matchers.JUnitMatchers.*;

/**
 * Test SimpleClass
 * 
 * @author rtholmes
 * 
 */
public class ValidateSimpleClass extends AbstractValidation {

	// done
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

	// done
	@Test
	public void checkFields() {
		// static
		Assert.assertTrue(_staticModel.hasField(Ids.SimpleClass_fieldA));
		Assert.assertNotNull(_staticModel.getField(Ids.SimpleClass_fieldA));
		Assert.assertEquals(Ids.SimpleClass_fieldA, _staticModel.getField(Ids.SimpleClass_fieldA).getId());

		ClassElement s_ce = _staticModel.getClass(Ids.SimpleClass);
		Assert.assertEquals(1, s_ce.getFields().size());
		Assert.assertThat(s_ce.getFields(), hasItem(_staticModel.getField(Ids.SimpleClass_fieldA)));

		// dynamic (commented out because we're not currently tracing field references)
		// Assert.assertTrue(_dynamicModel.hasField(Ids.SimpleClass_fieldA));
		// Assert.assertNotNull(_dynamicModel.getField(Ids.SimpleClass_fieldA));
		// Assert.assertEquals(Ids.SimpleClass_fieldA, _dynamicModel.getField(Ids.SimpleClass_fieldA).getId());
	}

	// done
	@Test
	public void checkMethods() {
		// static
		ClassElement s_ce = _staticModel.getClass(Ids.SimpleClass);
		Assert.assertNotNull(s_ce);
		Assert.assertEquals(28, s_ce.getMethods().size());

		Assert.assertTrue(_staticModel.hasMethod(Ids.SimpleClass_init));
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
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_init));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_a1));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_a2));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_b1));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_b2));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_c1));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_c2));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_d1));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_d2));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_e1));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_e2));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_f1));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_f2));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_g1));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_g2));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_h1));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_h2));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_i1));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_i2));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_j1));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_j2));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_l1));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_l2));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_m1));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_m2));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleClass_n0));
	}

	// Done
	@Test
	public void test_a() {
		// static

		// a1 properties
		MethodElement s_a1 = _staticModel.getMethod(Ids.SimpleClass_a1);
		Assert.assertNotNull(s_a1);
		Assert.assertEquals(Ids.Prim_void, s_a1.getReturnElement().getType().getId());
		Assert.assertEquals(0, s_a1.getParameters().size());

		// a2 properties
		MethodElement s_a2 = _staticModel.getMethod(Ids.SimpleClass_a2);
		Assert.assertNotNull(s_a2);
		Assert.assertEquals(s_a2.getReturnElement().getType().getId(), Ids.Prim_void);
		Assert.assertEquals(0, s_a2.getParameters().size());

		// a1 -> a2 static call
		Assert.assertEquals(1, s_a1.getCalls().size());
		Assert.assertEquals(0, s_a2.getCalls().size());
		Assert.assertTrue(s_a1.getCalls().contains(s_a2));

		// dynamic
		// a1
		MethodElement d_a1 = _dynamicModel.getMethod(Ids.SimpleClass_a1);
		Assert.assertNotNull(d_a1);

		// a2
		MethodElement d_a2 = _dynamicModel.getMethod(Ids.SimpleClass_a2);
		Assert.assertNotNull(d_a2);

		// a1 -> a2 dynamic call
		Assert.assertEquals(1, d_a1.getCalls().size());
		Assert.assertEquals(0, d_a2.getCalls().size());
		Assert.assertTrue(d_a1.getCalls().contains(d_a2));
	}

	// Done
	@Test
	public void test_b() {
		// static

		// b1 properties
		MethodElement s_b1 = _staticModel.getMethod(Ids.SimpleClass_b1);
		Assert.assertNotNull(s_b1);
		Assert.assertEquals(Ids.Prim_void, s_b1.getReturnElement().getType().getId());
		Assert.assertEquals(0, s_b1.getParameters().size());

		// b2 properties
		MethodElement s_b2 = _staticModel.getMethod(Ids.SimpleClass_b2);
		Assert.assertNotNull(s_b2);
		Assert.assertEquals(Ids.Vector, s_b2.getReturnElement().getType().getId());
		Assert.assertEquals(0, s_b2.getParameters().size());

		// b1 -> b2 static call
		Assert.assertEquals(2, s_b1.getCalls().size());
		Assert.assertEquals(1, s_b2.getCalls().size());
		Assert.assertTrue(s_b1.getCalls().contains(s_b2));

		// dynamic
		// b1
		MethodElement d_b1 = _dynamicModel.getMethod(Ids.SimpleClass_b1);
		Assert.assertNotNull(d_b1);

		// b2
		MethodElement d_b2 = _dynamicModel.getMethod(Ids.SimpleClass_b2);
		Assert.assertNotNull(d_b2);

		// b1 -> b2 dynamic call
		Assert.assertEquals(2, d_b1.getCalls().size());
		Assert.assertEquals(1, d_b2.getCalls().size());
		Assert.assertTrue(d_b1.getCalls().contains(d_b2));

	}

	// Done
	@Test
	public void test_c() {
		// static

		// c1 properties
		MethodElement s_c1 = _staticModel.getMethod(Ids.SimpleClass_c1);
		Assert.assertNotNull(s_c1);
		Assert.assertEquals(Ids.Prim_void, s_c1.getReturnElement().getType().getId());
		Assert.assertEquals(0, s_c1.getParameters().size());

		// c2 properties
		MethodElement s_c2 = _staticModel.getMethod(Ids.SimpleClass_c2);
		Assert.assertNotNull(s_c2);
		Assert.assertEquals(s_c2.getReturnElement().getType().getId(), Ids.Prim_void);
		// Assert.assertEquals(1, s_c2.getParameters().size()); issue #5 in depfind

		// c1 -> c2 static call
		Assert.assertEquals(1, s_c1.getCalls().size());
		Assert.assertEquals(0, s_c2.getCalls().size());
		Assert.assertTrue(s_c1.getCalls().contains(s_c2));

		// dynamic
		// c1
		MethodElement d_c1 = _dynamicModel.getMethod(Ids.SimpleClass_c1);
		Assert.assertNotNull(d_c1);

		// c2
		MethodElement d_c2 = _dynamicModel.getMethod(Ids.SimpleClass_c2);
		Assert.assertNotNull(d_c2);

		// c1 -> c2 dynamic call
		Assert.assertEquals(1, d_c1.getCalls().size());
		Assert.assertEquals(0, d_c2.getCalls().size());
		Assert.assertTrue(d_c1.getCalls().contains(d_c2));

	}

	// Done
	@Test
	public void test_d() {
		// static

		// d1 properties
		MethodElement s_d1 = _staticModel.getMethod(Ids.SimpleClass_d1);
		Assert.assertNotNull(s_d1);
		Assert.assertEquals(Ids.Prim_void, s_d1.getReturnElement().getType().getId());
		Assert.assertEquals(0, s_d1.getParameters().size());

		// d2 properties
		MethodElement s_d2 = _staticModel.getMethod(Ids.SimpleClass_d2);
		Assert.assertNotNull(s_d2);
		Assert.assertEquals(s_d2.getReturnElement().getType().getId(), Ids.Prim_void);
		// Assert.assertEquals(3, s_d2.getParameters().size()); issue #5 in depfind

		// d1 -> d2 static call
		Assert.assertEquals(1, s_d1.getCalls().size());
		Assert.assertEquals(0, s_d2.getCalls().size());
		Assert.assertTrue(s_d1.getCalls().contains(s_d2));

		// dynamic
		// d1
		MethodElement d_d1 = _dynamicModel.getMethod(Ids.SimpleClass_d1);
		Assert.assertNotNull(d_d1);

		// d2
		MethodElement d_d2 = _dynamicModel.getMethod(Ids.SimpleClass_d2);
		Assert.assertNotNull(d_d2);

		// d1 -> d2 dynamic call
		Assert.assertEquals(1, d_d1.getCalls().size());
		Assert.assertEquals(0, d_d2.getCalls().size());
		Assert.assertTrue(d_d1.getCalls().contains(d_d2));

	}

	// Done
	@Test
	public void test_e() {
		// static

		// e1 properties
		MethodElement s_e1 = _staticModel.getMethod(Ids.SimpleClass_e1);
		Assert.assertNotNull(s_e1);
		Assert.assertEquals(Ids.Prim_void, s_e1.getReturnElement().getType().getId());
		Assert.assertEquals(0, s_e1.getParameters().size());

		// e2 properties
		MethodElement s_e2 = _staticModel.getMethod(Ids.SimpleClass_e2);
		Assert.assertNotNull(s_e2);
		Assert.assertEquals(s_e2.getReturnElement().getType().getId(), Ids.Prim_void);
		// Assert.assertEquals(1, s_e2.getParameters().size()); issue #5 in depfind

		// e1 -> e2 static call
		Assert.assertEquals(2, s_e1.getCalls().size());
		Assert.assertEquals(1, s_e2.getCalls().size());
		Assert.assertTrue(s_e1.getCalls().contains(s_e2));

		// dynamic
		// e1
		MethodElement d_e1 = _dynamicModel.getMethod(Ids.SimpleClass_e1);
		Assert.assertNotNull(d_e1);

		// e2
		MethodElement d_e2 = _dynamicModel.getMethod(Ids.SimpleClass_e2);
		Assert.assertNotNull(d_e2);

		// e1 -> e2 dynamic call
		Assert.assertEquals(2, d_e1.getCalls().size());
		Assert.assertEquals(1, d_e2.getCalls().size());
		Assert.assertTrue(d_e1.getCalls().contains(d_e2));

		// e1 calls new Vector()
		Assert.assertThat(d_e1.getCalls(), hasItem(_dynamicModel.getMethod(Ids.Vector_init)));
		// e1 calls e2
		Assert.assertTrue(Iterators.contains(d_e1.getCalls().iterator(), d_e2));
	}

	// Done
	@Test
	public void test_f() {
		// static

		// f1 properties
		MethodElement s_f1 = _staticModel.getMethod(Ids.SimpleClass_f1);
		Assert.assertNotNull(s_f1); // exists
		Assert.assertEquals(Ids.Prim_void, s_f1.getReturnElement().getType().getId()); // void return
		Assert.assertEquals(0, s_f1.getParameters().size()); // no params
		Assert.assertEquals(2, s_f1.getCalls().size()); // makes 2 calls

		// f2 properties
		MethodElement s_f2 = _staticModel.getMethod(Ids.SimpleClass_f2);
		Assert.assertNotNull(s_f2); // exists
		Assert.assertEquals(Ids.Prim_void, s_f2.getReturnElement().getType().getId()); // void return

		Assert.assertEquals(1, s_f2.getParameters().size()); // has 1 param
		MethodParamElement mpe0 = new MethodParamElement(_staticModel.getClass(Ids.Collection), 0);
		Assert.assertTrue(Iterators.contains(s_f2.getParameters().iterator(), mpe0)); // param correct
		Assert.assertEquals(1, s_f2.getCalls().size()); // makes 0 calls

		// f1 calls new Vector()
		Assert.assertTrue(Iterators.contains(s_f1.getCalls().iterator(), _staticModel.getMethod(Ids.Vector_init)));
		// f1 calls f2
		Assert.assertTrue(Iterators.contains(s_f1.getCalls().iterator(), s_f2));

		// dynamic

		// f1
		MethodElement d_f1 = _dynamicModel.getMethod(Ids.SimpleClass_f1);
		Assert.assertNotNull(d_f1); // exists
		Assert.assertEquals(2, d_f1.getCalls().size()); // makes 2 calls

		// f2
		MethodElement d_f2 = _dynamicModel.getMethod(Ids.SimpleClass_f2);
		Assert.assertNotNull(d_f2); // exists
		Assert.assertEquals(1, d_f2.getCalls().size()); // makes 0 calls

		// f1 calls new Vector()
		Assert.assertTrue(Iterators.contains(d_f1.getCalls().iterator(), _dynamicModel.getMethod(Ids.Vector_init)));
		// f1 calls f2
		Assert.assertTrue(Iterators.contains(d_f1.getCalls().iterator(), d_f2));
	}

	// Done
	@Test
	public void test_g() {
		// static

		// g1 properties
		MethodElement s_g1 = _staticModel.getMethod(Ids.SimpleClass_g1);
		Assert.assertNotNull(s_g1);
		Assert.assertEquals(Ids.Prim_void, s_g1.getReturnElement().getType().getId());
		Assert.assertEquals(0, s_g1.getParameters().size());

		// g2 properties
		MethodElement s_g2 = _staticModel.getMethod(Ids.SimpleClass_g2);
		Assert.assertNotNull(s_g2);
		Assert.assertEquals(s_g2.getReturnElement().getType().getId(), Ids.Prim_void);
		// Assert.assertEquals(1, s_g2.getParameters().size()); issue #5 in depfind

		// g1 -> g2 static call
		Assert.assertEquals(2, s_g1.getCalls().size());
		Assert.assertEquals(1, s_g2.getCalls().size());
		Assert.assertTrue(s_g1.getCalls().contains(s_g2));

		// dynamic
		// g1
		MethodElement d_g1 = _dynamicModel.getMethod(Ids.SimpleClass_g1);
		Assert.assertNotNull(d_g1);

		// g2
		MethodElement d_g2 = _dynamicModel.getMethod(Ids.SimpleClass_g2);
		Assert.assertNotNull(d_g2);

		// g1 -> g2 dynamic call
		Assert.assertEquals(2, d_g1.getCalls().size());
		Assert.assertEquals(1, d_g2.getCalls().size());
		Assert.assertTrue(d_g1.getCalls().contains(d_g2));

		// g1 calls new Vector()
		Assert.assertTrue(Iterators.contains(d_g1.getCalls().iterator(), _dynamicModel.getMethod(Ids.Vector_init)));
		// g1 calls e2
		Assert.assertTrue(Iterators.contains(d_g1.getCalls().iterator(), d_g2));
	}

	// Done
	@Test
	public void test_h() {
		// static

		// h1 properties
		MethodElement s_h1 = _staticModel.getMethod(Ids.SimpleClass_h1);
		Assert.assertNotNull(s_h1);
		Assert.assertEquals(Ids.Prim_void, s_h1.getReturnElement().getType().getId());
		Assert.assertEquals(0, s_h1.getParameters().size());

		// h2 properties
		MethodElement s_h2 = _staticModel.getMethod(Ids.SimpleClass_h2);
		Assert.assertNotNull(s_h2);
		Assert.assertEquals(Ids.String, s_h2.getReturnElement().getType().getId());
		Assert.assertEquals(0, s_h2.getParameters().size());

		// h1 -> h2 static call
		Assert.assertEquals(2, s_h1.getCalls().size());
		Assert.assertEquals(0, s_h2.getCalls().size());
		Assert.assertTrue(s_h1.getCalls().contains(s_h2));

		// dynamic
		// h1
		MethodElement d_h1 = _dynamicModel.getMethod(Ids.SimpleClass_h1);
		Assert.assertNotNull(d_h1);

		// h2
		MethodElement d_h2 = _dynamicModel.getMethod(Ids.SimpleClass_h2);
		Assert.assertNotNull(d_h2);

		// h1 -> h2 dynamic call
		Assert.assertEquals(2, d_h1.getCalls().size());
		Assert.assertEquals(0, d_h2.getCalls().size());
		Assert.assertTrue(d_h1.getCalls().contains(d_h2));

	}

	// Done
	@Test
	public void test_i() {
		// static

		// i1 properties
		MethodElement s_i1 = _staticModel.getMethod(Ids.SimpleClass_i1);
		Assert.assertNotNull(s_i1);
		Assert.assertEquals(Ids.Prim_void, s_i1.getReturnElement().getType().getId());
		Assert.assertEquals(0, s_i1.getParameters().size());

		// i2 properties
		MethodElement s_i2 = _staticModel.getMethod(Ids.SimpleClass_i2);
		Assert.assertNotNull(s_i2);
		Assert.assertEquals(Ids.Vector, s_i2.getReturnElement().getType().getId());
		Assert.assertEquals(0, s_i2.getParameters().size());

		// i1 -> i2 static call
		Assert.assertEquals(2, s_i1.getCalls().size());
		Assert.assertEquals(1, s_i2.getCalls().size());
		Assert.assertTrue(s_i1.getCalls().contains(s_i2));

		// dynamic
		// i1
		MethodElement d_i1 = _dynamicModel.getMethod(Ids.SimpleClass_i1);
		Assert.assertNotNull(d_i1);

		// i2
		MethodElement d_i2 = _dynamicModel.getMethod(Ids.SimpleClass_i2);
		Assert.assertNotNull(d_i2);

		// i1 -> i2 dynamic call
		Assert.assertEquals(2, d_i1.getCalls().size());
		Assert.assertEquals(1, d_i2.getCalls().size());
		Assert.assertTrue(d_i1.getCalls().contains(d_i2));

		// i2 calls new Vector()
		Assert.assertTrue(Iterators.contains(d_i2.getCalls().iterator(), _dynamicModel.getMethod(Ids.Vector_init)));
		// i1 calls i2
		Assert.assertTrue(Iterators.contains(d_i1.getCalls().iterator(), d_i2));
	}

	// Done
	@Test
	public void test_j() {
		// static

		// j1 properties
		MethodElement s_j1 = _staticModel.getMethod(Ids.SimpleClass_j1);
		Assert.assertNotNull(s_j1);
		Assert.assertEquals(Ids.Prim_void, s_j1.getReturnElement().getType().getId());
		Assert.assertEquals(0, s_j1.getParameters().size());

		// j2 properties
		MethodElement s_j2 = _staticModel.getMethod(Ids.SimpleClass_j2);
		Assert.assertNotNull(s_j2);
		Assert.assertEquals(Ids.Collection, s_j2.getReturnElement().getType().getId());
		Assert.assertEquals(0, s_j2.getParameters().size());

		// j1 -> j2 static call
		Assert.assertEquals(2, s_j1.getCalls().size());
		Assert.assertEquals(1, s_j2.getCalls().size());
		Assert.assertTrue(s_j1.getCalls().contains(s_j2));

		// dynamic
		// j1
		MethodElement d_j1 = _dynamicModel.getMethod(Ids.SimpleClass_j1);
		Assert.assertNotNull(d_j1);

		// j2
		MethodElement d_j2 = _dynamicModel.getMethod(Ids.SimpleClass_j2);
		Assert.assertNotNull(d_j2);

		// j1 -> j2 dynamic call
		Assert.assertEquals(2, d_j1.getCalls().size());
		Assert.assertEquals(1, d_j2.getCalls().size());
		Assert.assertTrue(d_j1.getCalls().contains(d_j2));

		// j2 calls new Vector()
		Assert.assertTrue(Iterators.contains(d_j2.getCalls().iterator(), _dynamicModel.getMethod(Ids.Vector_init)));
		// j1 calls j2
		Assert.assertTrue(Iterators.contains(d_j1.getCalls().iterator(), d_j2));
	}

	// Done
	@Test
	public void test_k() {
		// static

		// k1 properties
		MethodElement s_k1 = _staticModel.getMethod(Ids.SimpleClass_k1);
		Assert.assertNotNull(s_k1);
		Assert.assertEquals(Ids.Prim_void, s_k1.getReturnElement().getType().getId());
		Assert.assertEquals(0, s_k1.getParameters().size());

		// k2 properties
		MethodElement s_k2 = _staticModel.getMethod(Ids.SimpleClass_k2);
		Assert.assertNotNull(s_k2);
		Assert.assertEquals(Ids.Prim_void, s_k2.getReturnElement().getType().getId());
		Assert.assertEquals(1, s_k2.getParameters().size());

		// k1 -> k2 static call
		Assert.assertEquals(2, s_k1.getCalls().size());
		Assert.assertEquals(1, s_k2.getCalls().size());
		Assert.assertTrue(s_k1.getCalls().contains(s_k2));

		// dynamic
		// k1
		MethodElement d_k1 = _dynamicModel.getMethod(Ids.SimpleClass_k1);
		Assert.assertNotNull(d_k1);

		// k2
		MethodElement d_k2 = _dynamicModel.getMethod(Ids.SimpleClass_k2);
		Assert.assertNotNull(d_k2);

		// k1 -> k2 dynamic call
		Assert.assertEquals(2, d_k1.getCalls().size());
		Assert.assertEquals(1, d_k2.getCalls().size());
		Assert.assertTrue(d_k1.getCalls().contains(d_k2));

		// k1 calls new Vector()
		Assert.assertTrue(Iterators.contains(d_k1.getCalls().iterator(), _dynamicModel.getMethod(Ids.Vector_init)));
		// k1 calls k2
		Assert.assertTrue(Iterators.contains(d_k1.getCalls().iterator(), d_k2));
	}

	// Done
	@Test
	public void test_l() {
		// static

		// l1 properties
		MethodElement s_l1 = _staticModel.getMethod(Ids.SimpleClass_l1);
		Assert.assertNotNull(s_l1);
		Assert.assertEquals(Ids.Prim_void, s_l1.getReturnElement().getType().getId());
		Assert.assertEquals(0, s_l1.getParameters().size());

		// l2 properties
		MethodElement s_l2 = _staticModel.getMethod(Ids.SimpleClass_l2);
		Assert.assertNotNull(s_l2);
		Assert.assertEquals(Ids.Prim_void, s_l2.getReturnElement().getType().getId());
		Assert.assertEquals(1, s_l2.getParameters().size());

		// l1 -> l2 static call
		Assert.assertEquals(2, s_l1.getCalls().size());
		Assert.assertEquals(1, s_l2.getCalls().size());
		Assert.assertTrue(s_l1.getCalls().contains(s_l2));

		// dynamic
		// l1
		MethodElement d_l1 = _dynamicModel.getMethod(Ids.SimpleClass_l1);
		Assert.assertNotNull(d_l1);

		// l2
		MethodElement d_l2 = _dynamicModel.getMethod(Ids.SimpleClass_l2);
		Assert.assertNotNull(d_l2);

		// l1 -> l2 dynamic call
		Assert.assertEquals(2, d_l1.getCalls().size());
		Assert.assertEquals(1, d_l2.getCalls().size());
		Assert.assertTrue(d_l1.getCalls().contains(d_l2));

		// l1 calls new Vector()
		Assert.assertTrue(Iterators.contains(d_l1.getCalls().iterator(), _dynamicModel.getMethod(Ids.Vector_init)));
		// l1 calls l2
		Assert.assertTrue(Iterators.contains(d_l1.getCalls().iterator(), d_l2));
	}

	// Done
	@Test
	public void test_m() {
		// static

		// m1 properties
		MethodElement s_m1 = _staticModel.getMethod(Ids.SimpleClass_m1);
		Assert.assertNotNull(s_m1);
		Assert.assertEquals(Ids.Prim_void, s_m1.getReturnElement().getType().getId());
		Assert.assertEquals(0, s_m1.getParameters().size());

		// m2 properties
		MethodElement s_m2 = _staticModel.getMethod(Ids.SimpleClass_m2);
		Assert.assertNotNull(s_m2);
		Assert.assertEquals(Ids.Prim_bool, s_m2.getReturnElement().getType().getId());
		// Assert.assertEquals(2, s_m2.getParameters().size()); issue #5 in depfind

		// m1 -> m2 static call
		Assert.assertEquals(1, s_m1.getCalls().size());
		Assert.assertEquals(0, s_m2.getCalls().size());
		Assert.assertTrue(s_m1.getCalls().contains(s_m2));

		// dynamic
		// m1
		MethodElement d_m1 = _dynamicModel.getMethod(Ids.SimpleClass_m1);
		Assert.assertNotNull(d_m1);

		// m2
		MethodElement d_m2 = _dynamicModel.getMethod(Ids.SimpleClass_m2);
		Assert.assertNotNull(d_m2);

		// m1 -> m2 dynamic call
		Assert.assertEquals(1, d_m1.getCalls().size());
		Assert.assertEquals(0, d_m2.getCalls().size());
		Assert.assertTrue(d_m1.getCalls().contains(d_m2));

	}

	// Done
	@Test
	public void test_fieldA() {
		// static
		FieldElement s_fieldA = _staticModel.getField(Ids.SimpleClass_fieldA);
		Assert.assertNotNull(s_fieldA);
		Assert.assertEquals(Ids.String, s_fieldA.getType().getId());

		// dynamic tracer doesn't record fields
	}

	// Done
	@Test
	public void test_n() {
		// static

		// n0 properties
		MethodElement s_n0 = _staticModel.getMethod(Ids.SimpleClass_n0);
		Assert.assertNotNull(s_n0);
		Assert.assertEquals(Ids.Prim_void, s_n0.getReturnElement().getType().getId());
		Assert.assertEquals(0, s_n0.getParameters().size());

		// fieldA properties
		FieldElement s_fieldA = _staticModel.getField(Ids.SimpleClass_fieldA);
		Assert.assertNotNull(s_fieldA); // field exists
		Assert.assertEquals(Ids.String, s_fieldA.getType().getId()); // type is string
		Assert.assertEquals(1, s_n0.getReferences().size()); // only 1 ref
		Assert.assertTrue(Iterators.contains(s_n0.getReferences().iterator(), s_fieldA)); // ref exists

		// dynamic

		// n0
		MethodElement d_n0 = _dynamicModel.getMethod(Ids.SimpleClass_n0);
		Assert.assertNotNull(d_n0);

		// TODO: dynamictracer Issue # 3
		// dynamic trace doesn't currently support field references
	}

}
