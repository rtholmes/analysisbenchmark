package ca.uwaterloo.cs.se.bench.simple;

import static org.junit.matchers.JUnitMatchers.hasItem;
import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;

import com.google.common.collect.Iterators;

import ca.uwaterloo.cs.se.bench.model.ClassElement;
import ca.uwaterloo.cs.se.bench.model.FieldElement;
import ca.uwaterloo.cs.se.bench.model.MethodElement;
import ca.uwaterloo.cs.se.bench.model.MethodParamElement;

import ca.uwaterloo.cs.se.bench.model.ClassElement;

/**
 * Test SimpleClass
 * 
 * @author koshikoj
 * 
 */


public class ValidateReflectionClass extends AbstractValidation {

	//done
	@Test
	public void checkClass() {
		// static
		ClassElement s_ce = _staticModel.getClass(Ids.ReflectionClass);
		Assert.assertNotNull(s_ce);

		Assert.assertFalse(s_ce.isExternal());
		Assert.assertFalse(s_ce.isAbstract());
		Assert.assertEquals(0, s_ce.getParents().size());

		// dynamic (nesting isn't captured by the tracer)
		// ClassElement d_ce = _dynamicModel.getClass(Ids.SimpleClass);
		// Assert.assertNotNull(d_ce);
	}
	
	
	@Test
	public void checkFields() {
		// static
		ClassElement s_ce = _staticModel.getClass(Ids.ReflectionClass);
		Assert.assertEquals(0, s_ce.getFields().size());

		// dynamic (commented out because we're not currently tracing field references)
		// Assert.assertTrue(_dynamicModel.hasField(Ids.SimpleClass_fieldA));
		// Assert.assertNotNull(_dynamicModel.getField(Ids.SimpleClass_fieldA));
		// Assert.assertEquals(Ids.SimpleClass_fieldA, _dynamicModel.getField(Ids.SimpleClass_fieldA).getId());
	}
	
	
	@Test
	public void checkMethods() {
		// static
		ClassElement s_ce = _staticModel.getClass(Ids.ReflectionClass);
		Assert.assertNotNull(s_ce);
		Assert.assertEquals(3, s_ce.getMethods().size());

		Assert.assertTrue(_staticModel.hasMethod(Ids.ReflectionClass_init));
		Assert.assertTrue(_staticModel.hasMethod(Ids.ReflectionClass_callVectorAddAndSize));
		Assert.assertTrue(_staticModel.hasMethod(Ids.ReflectionClass_instantiateString));

		// dynamic
		// aggregates not checked because tracer doesn't record containment
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.ReflectionClass_init));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.ReflectionClass_callVectorAddAndSize));
		Assert.assertTrue(_dynamicModel.hasMethod(Ids.ReflectionClass_instantiateString));

	}
	
	@Test
	public void Reflection_methods() {
		// static

		// a1 properties
		MethodElement s_a1 = _staticModel.getMethod(Ids.ReflectionClass_callVectorAddAndSize);
		Assert.assertNotNull(s_a1);
		Assert.assertEquals(Ids.Prim_void, s_a1.getReturnElement().getType().getId());
		Assert.assertEquals(0, s_a1.getParameters().size());

		// a2 properties
		MethodElement s_a2 = _staticModel.getMethod(Ids.ReflectionClass_instantiateString);
		Assert.assertNotNull(s_a2);
		Assert.assertEquals(s_a2.getReturnElement().getType().getId(), Ids.Prim_void);
		Assert.assertEquals(0, s_a2.getParameters().size());


		// dynamic

		MethodElement d_a1 = _dynamicModel.getMethod(Ids.ReflectionClass_callVectorAddAndSize);
		Assert.assertNotNull(d_a1);


		MethodElement d_a2 = _dynamicModel.getMethod(Ids.ReflectionClass_instantiateString);
		Assert.assertNotNull(d_a2);


	}
	
	
}
