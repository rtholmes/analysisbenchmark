package ca.uwaterloo.cs.se.bench.simple;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;

import ca.uwaterloo.cs.se.inconsistency.core.model2.ClassElement;
import ca.uwaterloo.cs.se.inconsistency.core.model2.FieldElement;
import ca.uwaterloo.cs.se.inconsistency.core.model2.MethodElement;
import ca.uwaterloo.cs.se.inconsistency.core.model2.MethodParamElement;

import com.google.common.collect.Iterators;

/**
 * Test SimpleClass
 * 
 * @author koshikoj
 * 
 */

public class ValidateFieldClass extends AbstractValidation {

	// Done
	@Test
	public void checkClass() {
		// static
		ClassElement s_ce = _staticModel.getClass(Ids.FieldClass);
		Assert.assertNotNull(s_ce);

		Assert.assertFalse(s_ce.isExternal());
		Assert.assertFalse(s_ce.isAbstract());
		Assert.assertEquals(0, s_ce.getParents().size());

		// dynamic (nesting isn't captured by the tracer)
		// ClassElement d_ce = _dynamicModel.getClass(Ids.SimpleClass);
		// Assert.assertNotNull(d_ce);
	}

	// Done
	@Test
	public void checkFields() {
		// static
		Assert.assertTrue(_staticModel.hasField(Ids.FieldClass_fieldString));
		Assert.assertNotNull(_staticModel.getField(Ids.FieldClass_fieldString));
		Assert.assertEquals(Ids.FieldClass_fieldString, _staticModel.getField(Ids.FieldClass_fieldString).getId());

		Assert.assertTrue(_staticModel.hasField(Ids.FieldClass_fieldStringValue));
		Assert.assertNotNull(_staticModel.getField(Ids.FieldClass_fieldStringValue));
		Assert.assertEquals(Ids.FieldClass_fieldStringValue, _staticModel.getField(Ids.FieldClass_fieldStringValue).getId());

		Assert.assertTrue(_staticModel.hasField(Ids.FieldClass_staticFieldVector));
		Assert.assertNotNull(_staticModel.getField(Ids.FieldClass_staticFieldVector));
		Assert.assertEquals(Ids.FieldClass_staticFieldVector, _staticModel.getField(Ids.FieldClass_staticFieldVector).getId());

		Assert.assertTrue(_staticModel.hasField(Ids.FieldClass_staticFieldVectorInit));
		Assert.assertNotNull(_staticModel.getField(Ids.FieldClass_staticFieldVectorInit));
		Assert.assertEquals(Ids.FieldClass_staticFieldVectorInit, _staticModel.getField(Ids.FieldClass_staticFieldVectorInit)
				.getId());

		Assert.assertTrue(_staticModel.hasField(Ids.FieldClass_staticBlockHashSetInit));
		Assert.assertNotNull(_staticModel.getField(Ids.FieldClass_staticBlockHashSetInit));
		Assert.assertEquals(Ids.FieldClass_staticBlockHashSetInit, _staticModel.getField(Ids.FieldClass_staticBlockHashSetInit)
				.getId());

		Assert.assertTrue(_staticModel.hasField(Ids.FieldClass_fieldStringInit));
		Assert.assertNotNull(_staticModel.getField(Ids.FieldClass_fieldStringInit));
		Assert.assertEquals(Ids.FieldClass_fieldStringInit, _staticModel.getField(Ids.FieldClass_fieldStringInit).getId());

		ClassElement s_ce = _staticModel.getClass(Ids.FieldClass);
		Assert.assertEquals(6, s_ce.getFields().size());
		Assert.assertTrue(Iterators.contains(s_ce.getFields().iterator(), _staticModel.getField(Ids.FieldClass_fieldString)));

		// dynamic (commented out because we're not currently tracing field references)
		// Assert.assertTrue(_dynamicModel.hasField(Ids.SimpleClass_fieldA));
		// Assert.assertNotNull(_dynamicModel.getField(Ids.SimpleClass_fieldA));
		// Assert.assertEquals(Ids.SimpleClass_fieldA, _dynamicModel.getField(Ids.SimpleClass_fieldA).getId());
	}

	@Test
	public void checkMethods() {
		// static
		ClassElement s_ce = _staticModel.getClass(Ids.FieldClass);
		Assert.assertNotNull(s_ce);
		Assert.assertEquals(2, s_ce.getMethods().size());

		Assert.assertTrue(_staticModel.hasMethod(Ids.FieldClass_init));

	}

}
