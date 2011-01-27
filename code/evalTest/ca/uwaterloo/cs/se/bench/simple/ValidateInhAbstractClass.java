package ca.uwaterloo.cs.se.bench.simple;

import org.junit.Assert;
import org.junit.Test;

import ca.uwaterloo.cs.se.bench.model.ClassElement;

public class ValidateInhAbstractClass extends AbstractValidation {

	@Test
	public void parseInhAbstractClass() {
		ClassElement ce = _staticModel.getClass(Ids.InhAbstractClass);
		Assert.assertNotNull(ce);

		Assert.assertFalse(ce.isInterface());
		Assert.assertTrue(ce.isAbstract());

		Assert.assertEquals(1, ce.getParents().size());
		Assert.assertEquals(0, ce.getFields().size());
		Assert.assertEquals(5, ce.getMethods().size());

		Assert.assertEquals(_staticModel.getClass(Ids.InhInterface), ce.getParents().iterator().next());
	}

}
