package ca.uwaterloo.cs.se.bench.simple;

import junit.framework.Assert;

import org.junit.Test;

import ca.uwaterloo.cs.se.inconsistency.core.model2.ClassElement;

/**
 * Test Primitive Types
 * 
 * @author rtholmes
 * 
 */
public class ValidatePrimitiveTypes extends AbstractValidation {

	@Test
	public void parseV() {
		ClassElement ce = _staticModel.getClass("void");
		Assert.assertNotNull(ce);

		Assert.assertTrue(ce.isExternal());

		Assert.assertEquals(0, ce.getParents().size());
		Assert.assertEquals(0, ce.getFields().size());
		Assert.assertEquals(0, ce.getMethods().size());
	}

}
