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

	@Test
	public void checkMethods() {
		// static
		ClassElement s_ce = _staticModel.getClass(Ids.InhInterface);
		Assert.assertNotNull(s_ce);
		Assert.assertEquals(3, s_ce.getMethods().size());

//		Assert.assertTrue(_staticModel.hasMethod(Ids.InhInterface_init));
		Assert.assertTrue(_staticModel.hasMethod(Ids.InhInterface_interfaceMethodA));
		Assert.assertTrue(_staticModel.hasMethod(Ids.InhInterface_interfaceMethodB));
		Assert.assertTrue(_staticModel.hasMethod(Ids.InhInterface_interfaceMethodC));

		// dynamic
		// aggregates not checked because tracer doesn't record containment
//		InhInterface not tested
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.InhInterface_init));
//		Assert.assertTrue(_dynamicModel.hasMethod(Ids.InhInterface_interfaceMethodA));
		//		Assert.assertTrue(_dynamicModel.hasMethod(Ids.InhInterface_interfaceMethodB));
//		Assert.assertTrue(_dynamicModel.hasMethod(Ids.InhInterface_interfaceMethodC));

	}
	
}
