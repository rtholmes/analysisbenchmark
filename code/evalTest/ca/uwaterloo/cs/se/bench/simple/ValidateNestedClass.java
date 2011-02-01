package ca.uwaterloo.cs.se.bench.simple;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;

import com.google.common.collect.Iterators;

import ca.uwaterloo.cs.se.bench.model.ClassElement;
import ca.uwaterloo.cs.se.bench.model.FieldElement;
import ca.uwaterloo.cs.se.bench.model.MethodElement;
import ca.uwaterloo.cs.se.bench.model.MethodParamElement;

/**
 * Test SimpleClass
 * 
 * @author koshikoj
 * 
 */
public class ValidateNestedClass extends AbstractValidation {

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
		Assert.assertEquals(Ids.NestedClass_nestedInitializedStringVector, _staticModel.getField(Ids.NestedClass_nestedInitializedStringVector)
				.getId());

		ClassElement s_ce = _staticModel.getClass(Ids.NestedClass);
		Assert.assertEquals(4, s_ce.getFields().size());
		Assert.assertTrue(Iterators.contains(s_ce.getFields().iterator(), _staticModel.getField(Ids.NestedClass_nestedString)));

		// dynamic (commented out because we're not currently tracing field references)
		// Assert.assertTrue(_dynamicModel.hasField(Ids.SimpleClass_fieldA));
		// Assert.assertNotNull(_dynamicModel.getField(Ids.SimpleClass_fieldA));
		// Assert.assertEquals(Ids.SimpleClass_fieldA, _dynamicModel.getField(Ids.SimpleClass_fieldA).getId());
	}

	// Can't check inner methods until issue #23 fixed
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

		// dynamic
		// aggregates not checked because tracer doesn't record containment
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.NestedClass_init));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.NestedClass_nestedMethodA));
		// B isn't called in the test suite
		// Assert.assertTrue(_dynamicModel.hasMethod(Ids.NestedClass_nestedMethodB));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.NestedClass_nestedMethodC));

	}

}
