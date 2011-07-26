package ca.uwaterloo.cs.se.bench.simple.model;

import org.junit.Assert;
import org.junit.Test;

import ca.uwaterloo.cs.se.inconsistency.core.model2.ClassElement;
import ca.uwaterloo.cs.se.inconsistency.core.model2.MethodParamElement;
import ca.uwaterloo.cs.se.inconsistency.core.model2.MethodReturnElement;
import static org.hamcrest.CoreMatchers.*;

public class TestMethodReturnElement {

	@Test
	public void testEqualsHashcodeSameCE() {
		ClassElement ce = new ClassElement("typeA", true);

		MethodReturnElement mre1 = new MethodReturnElement(ce);
		Assert.assertThat(mre1, is(mre1));
		Assert.assertThat(mre1.hashCode(), is(mre1.hashCode()));

		MethodReturnElement mre2 = new MethodReturnElement(ce);
		Assert.assertThat(mre2, is(mre2));
		Assert.assertThat(mre2.hashCode(), is(mre2.hashCode()));

		// mpe1 and mpe2 should be equal
		Assert.assertThat(mre1, is(mre2));
		Assert.assertThat(mre1.hashCode(), is(mre2.hashCode()));

		ClassElement ce2 = new ClassElement("typeB", true);
		MethodReturnElement mre3 = new MethodReturnElement(ce2);
		Assert.assertThat(mre3, is(mre3));
		Assert.assertThat(mre3.hashCode(), is(mre3.hashCode()));

		// mpe3 !equal mpe1 or mpe2
		Assert.assertThat(mre1, is(not(mre3)));
		Assert.assertThat(mre3, is(not(mre1)));
		Assert.assertThat(mre1.hashCode(), is(not(mre3.hashCode())));

		Assert.assertThat(mre2, is(not(mre3)));
		Assert.assertThat(mre3, is(not(mre2)));
		Assert.assertThat(mre2.hashCode(), is(not(mre3.hashCode())));
	}

	@Test
	public void testEqualsHashcodeDifferentCE() {
		ClassElement ce1 = new ClassElement("typeA", true);
		ClassElement ce2 = new ClassElement("typeA", true);
		ClassElement ce3 = new ClassElement("typeB", true);

		MethodReturnElement mre1 = new MethodReturnElement(ce1);
		Assert.assertThat(mre1, is(mre1));
		Assert.assertThat(mre1.hashCode(), is(mre1.hashCode()));

		MethodReturnElement mre2 = new MethodReturnElement(ce2);
		Assert.assertThat(mre2, is(mre2));
		Assert.assertThat(mre2.hashCode(), is(mre2.hashCode()));

		// mpe1 and mpe2 should be equal
		Assert.assertThat(mre1, is(mre2));
		Assert.assertThat(mre1.hashCode(), is(mre2.hashCode()));

		MethodReturnElement mre3 = new MethodReturnElement(ce3);
		Assert.assertThat(mre3, is(mre3));
		Assert.assertThat(mre3.hashCode(), is(mre3.hashCode()));

		// mpe3 !equal mpe1 or mpe2
		Assert.assertThat(mre1, is(not(mre3)));
		Assert.assertThat(mre3, is(not(mre1)));
		Assert.assertThat(mre1.hashCode(), is(not(mre3.hashCode())));

		Assert.assertThat(mre2, is(not(mre3)));
		Assert.assertThat(mre3, is(not(mre2)));
		Assert.assertThat(mre2.hashCode(), is(not(mre3.hashCode())));
	}

	@Test
	public void testEqualsMethodParamElement() {
		ClassElement ce1 = new ClassElement("typeA", true);

		MethodReturnElement mre1 = new MethodReturnElement(ce1);
		Assert.assertThat(mre1, is(mre1));

		MethodParamElement mpe1 = new MethodParamElement(ce1, 0);
		Assert.assertThat(mpe1, is(mpe1));

		// because of type erasure we can't say Assert.assertThat(mre1, is(not(mpe1)));
		Assert.assertFalse(mre1.equals(mpe1));
		Assert.assertFalse(mpe1.equals(mre1));
	}
}
