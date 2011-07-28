package ca.uwaterloo.cs.se.bench.simple;

import org.junit.Test;

@Deprecated
public class AnnotationClass {

	@Deprecated
	Class f;

	@Deprecated
	public void hasJDKAnnotation() {

	}

	@Test
	public void hasJUnitAnnotation() {

	}

	// NOTE: Do NOT remove these warnings; they are for testing
	// NOTE: @Suppresswarnings is only a source annotation, it does not get compiled so these don't get picked up by depfind
	@SuppressWarnings({ "deprecation", "unused" })
	public void hadCompoundAnnotation() {

	}

	@Test
	@Deprecated
	public void hasMultipleAnnotations() {

	}
}
