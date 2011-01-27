package ca.uwaterloo.cs.se.bench.simple;

import junit.framework.Assert;

import org.junit.Test;

import ca.uwaterloo.cs.se.bench.model.ClassElement;

/**
 * Test InhInterface
 * 
 * @author rtholmes
 * 
 */
public class ValidateInhInterface extends AbstractValidation {

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

}
