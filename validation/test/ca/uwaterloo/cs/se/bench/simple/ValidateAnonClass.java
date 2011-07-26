package ca.uwaterloo.cs.se.bench.simple;

import static org.junit.matchers.JUnitMatchers.hasItem;
import junit.framework.Assert;

import org.junit.Test;

import ca.uwaterloo.cs.se.bench.model.ClassElement;

/**
 * Test AnonClass
 * 
 * @author rtholmes
 * 
 */
public class ValidateAnonClass extends AbstractValidation {

	@Test
	public void checkClass() {
		ClassElement s_ce = _staticModel.getClass(Ids.AnonClass);
		Assert.assertNotNull(s_ce);

		Assert.assertFalse(s_ce.isInterface());
		Assert.assertFalse(s_ce.isAbstract());

		Assert.assertEquals(0, s_ce.getParents().size());
		Assert.assertEquals(0, s_ce.getFields().size());

		// TODO: missing checks for the two anoymmous classes (e.g., ca...AnonClass$1, and ca...AnonClass$2) and their parent types

		// only have a call graph (between methods) right now
		// ClassElement d_ce = _dynamicModel.getClass(Ids.AnonClass);
		// Assert.assertNotNull(d_ce);
	}

	@Test
	public void checkFields() {
		// static

		ClassElement s_ce = _staticModel.getClass(Ids.AnonClass);
		Assert.assertEquals(0, s_ce.getFields().size());

		// dynamic (commented out because we're not currently tracing field references)
		// Assert.assertTrue(_dynamicModel.hasField(Ids.SimpleClass_fieldA));
		// Assert.assertNotNull(_dynamicModel.getField(Ids.SimpleClass_fieldA));
		// Assert.assertEquals(Ids.SimpleClass_fieldA, _dynamicModel.getField(Ids.SimpleClass_fieldA).getId());
	}

	@Test
	public void checkMethods() {
		ClassElement s_ce = _staticModel.getClass(Ids.AnonClass);
		Assert.assertNotNull(s_ce);
		Assert.assertEquals(3, s_ce.getMethods().size());

		Assert.assertTrue(_staticModel.hasMethod(Ids.AnonClass_simpleAnonymous));
		Assert.assertTrue(_staticModel.hasMethod(Ids.AnonClass_genericAnonymous));
		Assert.assertTrue(_staticModel.hasMethod(Ids.AnonClass_simpleAnonymous_compare));
		Assert.assertTrue(_staticModel.hasMethod(Ids.AnonClass_genericAnonymous_compare));

		Assert.assertTrue(_dynamicModel.hasMethod(Ids.AnonClass_simpleAnonymous));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.AnonClass_genericAnonymous));

		// 
		// Assert.assertTrue(_dynamicModel.hasMethod(Ids.AnonClass_simpleAnonymous_compare));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.AnonClass_genericAnonymous_compare));

		// TODO: missing checks for the anonymous methods (e.g., ca...SimpleAnonymous$1.compare(String, String))
	}

}