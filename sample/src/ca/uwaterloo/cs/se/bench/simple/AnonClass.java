package ca.uwaterloo.cs.se.bench.simple;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class AnonClass {

	@SuppressWarnings("unchecked")
	public void simpleAnonymous() {
		Vector v = new Vector();
		v.add("one");
		v.add("two");

		Collections.sort(new Vector(), new Comparator() {

			@Override
			public int compare(Object arg0, Object arg1) {
				return ((String) arg0).compareTo((String) arg1);
			}

		});
	}

	public void genericAnonymous() {
		Vector<String> v = new Vector<String>();
		v.add("one");
		v.add("two");

		Collections.sort(v, new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				return arg0.compareTo(arg1);
			}

		});
	}

}
