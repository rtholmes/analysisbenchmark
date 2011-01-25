package ca.uwaterloo.cs.se.bench.simple;

import java.util.Vector;

public class NestedClass {

	String nestedString;
	Vector nestedVector;
	Vector<String> nestedStringVector;
	Vector<String> nestedInitializedStringVector = new Vector<String>();

	public void nestedMethodA() {
		nestedInitializedStringVector.add("nestedMethodA");
	}

	public void nestedMethodB() {

	}

	public void nestedMethodC() {

	}

	public class InnerClass {
		public void innerMethodA() {
			nestedInitializedStringVector.add("innerMethodA");
		}

		public void innerMethodB() {

		}

		public void innerMethodC() {
			nestedMethodC();
		}

		public class InnerInnerClass {
			public void innerInnerMethodA() {
				nestedInitializedStringVector.add("innerInnerMethodA");
			}

			public void innerInnerMethodB() {
				innerMethodB();
			}

			public void innerInnerMethodC() {
				innerMethodC();
			}
		}
	}
}
