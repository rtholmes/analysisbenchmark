package ca.uwaterloo.cs.se.bench;

import junit.framework.Assert;

import org.junit.Test;

import ca.uwaterloo.cs.se.bench.model.ClassElement;

/**
 * Test InhClassA
 * 
 * @author rtholmes
 * 
 */
public class ValidateInhClassA extends AbstractValidation {

	@Test
	public void parseInhClassA() {
		ClassElement ce = _staticModel.getClass(Ids.InhClassA);
		Assert.assertNotNull(ce);

		Assert.assertFalse(ce.isInterface());
		Assert.assertFalse(ce.isAbstract());

		Assert.assertEquals(1, ce.getParents().size());
		Assert.assertEquals(0, ce.getFields().size());
		Assert.assertEquals(5, ce.getMethods().size());

		Assert.assertEquals(_staticModel.getClass(Ids.InhAbstractClass), ce.getParents().iterator().next());
	}

}