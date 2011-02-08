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

	@Test
	public void checkMethods() {
		// static
		ClassElement s_ce = _staticModel.getClass(Ids.InhAbstractClass);
		Assert.assertNotNull(s_ce);
		Assert.assertEquals(5, s_ce.getMethods().size());

		Assert.assertTrue(_staticModel.hasMethod(Ids.InhAbstractClass_init));
		Assert.assertTrue(_staticModel.hasMethod(Ids.InhAbstractClass_interfaceMethodA));
		Assert.assertTrue(_staticModel.hasMethod(Ids.InhAbstractClass_interfaceMethodC));
		Assert.assertTrue(_staticModel.hasMethod(Ids.InhAbstractClass_abstractMethodA));
		Assert.assertTrue(_staticModel.hasMethod(Ids.InhAbstractClass_abstractMethodB));
		
		// dynamic
		// aggregates not checked because tracer doesn't record containment
//		InhInterface not tested
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.InhAbstractClass_init));
//		Assert.assertTrue(_dynamicModel.hasMethod(Ids.InhAbstractClass_interfaceMethodA));
//		Assert.assertTrue(_dynamicModel.hasMethod(Ids.InhAbstractClass_abstractMethodA));
//		Assert.assertTrue(_dynamicModel.hasMethod(Ids.InhAbstractClass_interfaceMethodC));
//		Assert.assertTrue(_dynamicModel.hasMethod(Ids.InhAbstractClass_abstractMethodB));
		
	}
	
}
