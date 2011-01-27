package ca.uwaterloo.cs.se.bench.model;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class TestMethodParamElement {

	@Test
	public void testEqualsHashcodeSameCE() {
		ClassElement ce = new ClassElement("typeA", true);

		MethodParamElement mpe1 = new MethodParamElement(ce, 0);
		Assert.assertThat(mpe1, is(mpe1));
		Assert.assertThat(mpe1.hashCode(), is(mpe1.hashCode()));

		MethodParamElement mpe2 = new MethodParamElement(ce, 0);
		Assert.assertThat(mpe2, is(mpe2));
		Assert.assertThat(mpe2.hashCode(), is(mpe2.hashCode()));

		// mpe1 and mpe2 should be equal
		Assert.assertThat(mpe1, is(mpe2));
		Assert.assertThat(mpe1.hashCode(), is(mpe2.hashCode()));

		MethodParamElement mpe3 = new MethodParamElement(ce, 1);
		Assert.assertThat(mpe3, is(mpe3));
		Assert.assertThat(mpe3.hashCode(), is(mpe3.hashCode()));

		// mpe3 !equal mpe1 or mpe2
		Assert.assertThat(mpe1, is(not(mpe3)));
		Assert.assertThat(mpe3, is(not(mpe1)));
		Assert.assertThat(mpe1.hashCode(), is(not(mpe3.hashCode())));

		Assert.assertThat(mpe2, is(not(mpe3)));
		Assert.assertThat(mpe3, is(not(mpe2)));
		Assert.assertThat(mpe2.hashCode(), is(not(mpe3.hashCode())));
	}

	@Test
	public void testEqualsHashcodeDifferentCE() {
		ClassElement ce1 = new ClassElement("typeA", true);
		ClassElement ce2 = new ClassElement("typeA", true);
		ClassElement ce3 = new ClassElement("typeB", true);

		MethodParamElement mpe1 = new MethodParamElement(ce1, 0);
		Assert.assertThat(mpe1, is(mpe1));
		Assert.assertThat(mpe1.hashCode(), is(mpe1.hashCode()));

		MethodParamElement mpe2 = new MethodParamElement(ce2, 0);
		Assert.assertThat(mpe2, is(mpe2));
		Assert.assertThat(mpe2.hashCode(), is(mpe2.hashCode()));

		// mpe1 and mpe2 should be equal
		Assert.assertThat(mpe1, is(mpe2));
		Assert.assertThat(mpe1.hashCode(), is(mpe2.hashCode()));

		MethodParamElement mpe3 = new MethodParamElement(ce3, 0);
		Assert.assertThat(mpe3, is(mpe3));
		Assert.assertThat(mpe3.hashCode(), is(mpe3.hashCode()));

		// mpe3 !equal mpe1 or mpe2
		Assert.assertThat(mpe1, is(not(mpe3)));
		Assert.assertThat(mpe3, is(not(mpe1)));
		Assert.assertThat(mpe1.hashCode(), is(not(mpe3.hashCode())));

		Assert.assertThat(mpe2, is(not(mpe3)));
		Assert.assertThat(mpe3, is(not(mpe2)));
		Assert.assertThat(mpe2.hashCode(), is(not(mpe3.hashCode())));
	}

	@Test
	public void testEqualsMethodReturnElement() {
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
