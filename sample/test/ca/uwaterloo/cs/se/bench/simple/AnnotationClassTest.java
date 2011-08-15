package ca.uwaterloo.cs.se.bench.simple;

import org.junit.Test;

public class AnnotationClassTest {

	@Test
	@SuppressWarnings("deprecation")
	public void hasJDKAnnotation() {
		AnnotationClass ac = new AnnotationClass();
		ac.hasJDKAnnotation();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void hasJUnitAnnotation() {
		AnnotationClass ac = new AnnotationClass();
		ac.hasJUnitAnnotation();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void hadCompoundAnnotation() {
		AnnotationClass ac = new AnnotationClass();
		ac.hadCompoundAnnotation();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void hasMultipleAnnotations() {
		AnnotationClass ac = new AnnotationClass();
		ac.hasMultipleAnnotations();
	}
}
