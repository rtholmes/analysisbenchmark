package ca.uwaterloo.cs.se.bench.simple;

import junit.framework.Assert;

import org.junit.Test;

import ca.uwaterloo.cs.se.inconsistency.core.model2.ClassElement;

/**
 * Test External Libraries
 * 
 * @author rtholmes
 * 
 */
public class ValidateExternalLibraries extends AbstractValidation {

	@Test
	public void parseCollection() {
		ClassElement ce = _staticModel.getClass(Ids.Collection);
		Assert.assertNotNull(ce);

		Assert.assertTrue(ce.isExternal());

		Assert.assertEquals(0, ce.getParents().size());
		Assert.assertEquals(0, ce.getFields().size());
		Assert.assertEquals(1, ce.getMethods().size());
	}

	@Test
	public void parseVector() {
		ClassElement ce = _staticModel.getClass(Ids.Vector);
		Assert.assertNotNull(ce);

		Assert.assertTrue(ce.isExternal());

		Assert.assertEquals(0, ce.getParents().size());
		Assert.assertEquals(0, ce.getFields().size());
		Assert.assertEquals(4, ce.getMethods().size()); // Vector(), add(Object)

		Assert.assertEquals(Ids.Vector_init, ce.getMethods().iterator().next().getId());
	}

	@Test
	public void parseString() {
		ClassElement ce = _staticModel.getClass(Ids.String);
		Assert.assertNotNull(ce);

		Assert.assertTrue(ce.isExternal());

		Assert.assertEquals(0, ce.getParents().size());
		Assert.assertEquals(0, ce.getFields().size());
		Assert.assertEquals(7, ce.getMethods().size());
	}
}
