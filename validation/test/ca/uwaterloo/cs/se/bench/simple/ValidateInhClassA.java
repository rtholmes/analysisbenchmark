package ca.uwaterloo.cs.se.bench.simple;

import junit.framework.Assert;

import org.junit.Test;

import ca.uwaterloo.cs.se.inconsistency.core.model2.ClassElement;

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

	@Test
	public void checkMethods() {
		// static
		ClassElement s_ce = _staticModel.getClass(Ids.InhClassA);
		Assert.assertNotNull(s_ce);
		Assert.assertEquals(5, s_ce.getMethods().size());

		Assert.assertTrue(_staticModel.hasMethod(Ids.InhClassA_init));
		Assert.assertTrue(_staticModel.hasMethod(Ids.InhClassA_interfaceMethodA));
		Assert.assertTrue(_staticModel.hasMethod(Ids.InhClassA_interfaceMethodB));
		Assert.assertTrue(_staticModel.hasMethod(Ids.InhClassA_abstractMethodA));
		Assert.assertTrue(_staticModel.hasMethod(Ids.InhClassA_InhAbstractClass_interfaceMethodA));
		Assert.assertTrue(_staticModel.hasMethod(Ids.InhClassA_InhInterface_interfaceMethodA));
		Assert.assertTrue(_staticModel.hasMethod(Ids.InhClassA_InhAbstractClass_abstractMethodA));
		
		// dynamic
		// aggregates not checked because tracer doesn't record containment
		// InhInterface not tested
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.InhClassA_init));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.InhClassA_interfaceMethodA));
		// Assert.assertTrue(_dynamicModel.hasMethod(Ids.InhClassA_interfaceMethodB));

		/*error see test #25
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.InhClassA_abstractMethodA));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.InhClassA_InhAbstractClass_interfaceMethodA));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.InhClassA_InhInterface_interfaceMethodA));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.InhClassA_InhAbstractClass_abstractMethodA));
		*/
	}
}