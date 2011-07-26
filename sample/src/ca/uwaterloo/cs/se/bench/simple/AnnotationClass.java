package ca.uwaterloo.cs.se.bench.simple;

import org.junit.Test;

public class AnnotationClass {

	@Deprecated
	public void hasJDKAnnotation() {

	}

	@Test
	public void hasJUnitAnnotation() {

	}

	// NOTE: Do NOT remove these warnings; they are for testing
	@SuppressWarnings({ "deprecation", "unused" })
	public void hadCompoundAnnotation() {

	}

	@Test
	@Deprecated
	public void hasMultipleAnnotations() {

	}
}
