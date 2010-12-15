package ca.uwaterloo.cs.se.bench;

import java.util.Collection;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import ca.uwaterloo.cs.se.bench.model.ClassElement;
import ca.uwaterloo.cs.se.bench.model.io.XMLReaderDependencyFinder;

/**
 * Synthetic test; essentially makes sure the eval code is working separate from the suite that will actually test the
 * model.
 * 
 * @author rtholmes
 * 
 */
public class SyntheticModelTest {

	private final String fName = "testResources/static_synthetic.xml";

	@BeforeClass
	public static void beforeClass() {
		XMLReaderDependencyFinder.startLog4J(true);
	}

	@Test
	public void parseSytheticModel() {

		XMLReaderDependencyFinder xmlrdf = new XMLReaderDependencyFinder(fName);
		Collection<ClassElement> model = xmlrdf.parseModel();

		Assert.assertNotNull(model);
	}

}
