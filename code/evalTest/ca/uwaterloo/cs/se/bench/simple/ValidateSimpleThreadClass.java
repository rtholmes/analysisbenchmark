package ca.uwaterloo.cs.se.bench.simple;

import static org.junit.matchers.JUnitMatchers.hasItem;

import static org.hamcrest.CoreMatchers.not;

import org.junit.Assert;
import org.junit.Test;

import ca.uwaterloo.cs.se.bench.model.ClassElement;
import ca.uwaterloo.cs.se.bench.model.MethodElement;

public class ValidateSimpleThreadClass extends AbstractValidation {

	@Test
	public void checkClass() {
		// static
		ClassElement s_ce = _staticModel.getClass(Ids.SimpleThreadClass);
		Assert.assertNotNull(s_ce);

		Assert.assertFalse(s_ce.isExternal());
		Assert.assertFalse(s_ce.isAbstract());
		Assert.assertEquals(0, s_ce.getParents().size());

		ClassElement s_ceA = _staticModel.getClass(Ids.SimpleThreadClass_ThreadA);
		Assert.assertNotNull(s_ceA);

		Assert.assertFalse(s_ceA.isExternal());
		Assert.assertFalse(s_ceA.isAbstract());
		Assert.assertEquals(1, s_ceA.getParents().size());
		Assert.assertThat(s_ceA.getParents(), hasItem(_staticModel.getClass(Ids.Thread)));

		ClassElement s_ceB = _staticModel.getClass(Ids.SimpleThreadClass_ThreadB);
		Assert.assertNotNull(s_ceB);

		Assert.assertFalse(s_ceB.isExternal());
		Assert.assertFalse(s_ceB.isAbstract());
		Assert.assertEquals(1, s_ceB.getParents().size());
		Assert.assertThat(s_ceB.getParents(), hasItem(_staticModel.getClass(Ids.Thread)));

		// dynamic (nesting isn't captured by the tracer)
		// ClassElement d_ce = _dynamicModel.getClass(Ids.SimpleThreadClass);
		// Assert.assertNotNull(d_ce);
	}

	// done
	@Test
	public void checkFields() {
		// static
		Assert.assertTrue(_staticModel.hasField(Ids.SimpleThreadClass_ThreadA_count));
		Assert.assertNotNull(_staticModel.getField(Ids.SimpleThreadClass_ThreadA_count));
		Assert.assertEquals(Ids.SimpleThreadClass_ThreadA_count, _staticModel.getField(Ids.SimpleThreadClass_ThreadA_count).getId());

		Assert.assertTrue(_staticModel.hasField(Ids.SimpleThreadClass_ThreadA_tick));
		Assert.assertNotNull(_staticModel.getField(Ids.SimpleThreadClass_ThreadA_tick));
		Assert.assertEquals(Ids.SimpleThreadClass_ThreadA_tick, _staticModel.getField(Ids.SimpleThreadClass_ThreadA_tick).getId());

		ClassElement s_ceA = _staticModel.getClass(Ids.SimpleThreadClass_ThreadA);
		Assert.assertEquals(3, s_ceA.getFields().size());
		Assert.assertThat(s_ceA.getFields(), hasItem(_staticModel.getField(Ids.SimpleThreadClass_ThreadA_count)));
		Assert.assertThat(s_ceA.getFields(), hasItem(_staticModel.getField(Ids.SimpleThreadClass_ThreadA_tick)));
		// NOTE: if this fails due to some future change that's ok, this is just put in there by the compiler
		Assert.assertThat(s_ceA.getFields(), hasItem(_staticModel.getField(Ids.SimpleThreadClass_ThreadA_this)));

		ClassElement s_ceB = _staticModel.getClass(Ids.SimpleThreadClass_ThreadB);
		Assert.assertEquals(3, s_ceB.getFields().size());
		Assert.assertThat(s_ceB.getFields(), hasItem(_staticModel.getField(Ids.SimpleThreadClass_ThreadB_count)));
		Assert.assertThat(s_ceB.getFields(), hasItem(_staticModel.getField(Ids.SimpleThreadClass_ThreadB_tick)));
		// NOTE: if this fails due to some future change that's ok, this is just put in there by the compiler
		Assert.assertThat(s_ceB.getFields(), hasItem(_staticModel.getField(Ids.SimpleThreadClass_ThreadB_this)));

		// dynamic (not currently tracing field references)
	}

	// done
	@Test
	public void checkMethods() {
		// static
		ClassElement s_ce = _staticModel.getClass(Ids.SimpleThreadClass);
		Assert.assertNotNull(s_ce);
		// NOTE: We would like to assess this but some '.access$000' style methods are being generated and captured by the extractor
		// Assert.assertEquals(4, s_ce.getMethods().size());

		Assert.assertTrue(_staticModel.hasMethod(Ids.SimpleThreadClass_init));
		Assert.assertTrue(_staticModel.hasMethod(Ids.SimpleThreadClass_a));
		Assert.assertTrue(_staticModel.hasMethod(Ids.SimpleThreadClass_b));
		Assert.assertTrue(_staticModel.hasMethod(Ids.SimpleThreadClass_compute));
		Assert.assertTrue(_staticModel.hasMethod(Ids.SimpleThreadClass_run));

		Assert.assertTrue(_staticModel.hasMethod(Ids.SimpleThreadClass_ThreadA_run));
		Assert.assertTrue(_staticModel.hasMethod(Ids.SimpleThreadClass_ThreadB_run));

		// dynamic
		// aggregates not checked because tracer doesn't record containment
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleThreadClass_init));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleThreadClass_a));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleThreadClass_b));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleThreadClass_compute));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleThreadClass_run));

		Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleThreadClass_ThreadA_run));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.SimpleThreadClass_ThreadB_run));

	}

	@Test
	public void test_a() {
		// static

		// c1 properties
		MethodElement s_a = _staticModel.getMethod(Ids.SimpleThreadClass_a);
		Assert.assertNotNull(s_a);
		Assert.assertEquals(Ids.String, s_a.getReturnElement().getType().getId());
		Assert.assertEquals(0, s_a.getParameters().size());

		Assert.assertEquals(1, s_a.getCalls().size());
		Assert.assertThat(s_a.getCalls(), hasItem(_staticModel.getMethod(Ids.SimpleThreadClass_compute)));

		MethodElement d_a = _dynamicModel.getMethod(Ids.SimpleThreadClass_a);
		Assert.assertNotNull(d_a);

		// Threading test; a() only calls compute(String)
		Assert.assertEquals(1, d_a.getCalls().size());
		Assert.assertThat(d_a.getCalls(), hasItem(_dynamicModel.getMethod(Ids.SimpleThreadClass_compute)));

		for (MethodElement me : _dynamicModel.getMethods()) {
			if (me.getId().equals(Ids.SimpleThreadClass_ThreadA_run)) {
				// ensure run() calls a()
				Assert.assertThat(me.getCalls(), hasItem(_dynamicModel.getMethod(Ids.SimpleThreadClass_a)));
			} else {
				// ensure no other method calls a()
				Assert.assertThat(me.getCalls(), not(hasItem(_dynamicModel.getMethod(Ids.SimpleThreadClass_a))));
			}
		}
	}

	@Test
	public void test_b() {
		// static

		// c1 properties
		MethodElement s_b = _staticModel.getMethod(Ids.SimpleThreadClass_b);
		Assert.assertNotNull(s_b);
		Assert.assertEquals(Ids.String, s_b.getReturnElement().getType().getId());
		Assert.assertEquals(0, s_b.getParameters().size());

		Assert.assertEquals(1, s_b.getCalls().size());
		Assert.assertThat(s_b.getCalls(), hasItem(_staticModel.getMethod(Ids.SimpleThreadClass_compute)));

		MethodElement d_b = _dynamicModel.getMethod(Ids.SimpleThreadClass_b);
		Assert.assertNotNull(d_b);

		// Threading test; b() only calls compute(String)
		Assert.assertEquals(1, d_b.getCalls().size());
		Assert.assertThat(d_b.getCalls(), hasItem(_dynamicModel.getMethod(Ids.SimpleThreadClass_compute)));

		for (MethodElement me : _dynamicModel.getMethods()) {
			if (me.getId().equals(Ids.SimpleThreadClass_ThreadB_run)) {
				// ensure run() calls b()
				Assert.assertThat(me.getCalls(), hasItem(_dynamicModel.getMethod(Ids.SimpleThreadClass_b)));
			} else {
				// ensure no other method calls b()
				Assert.assertThat(me.getCalls(), not(hasItem(_dynamicModel.getMethod(Ids.SimpleThreadClass_b))));
			}
		}
	}

}
