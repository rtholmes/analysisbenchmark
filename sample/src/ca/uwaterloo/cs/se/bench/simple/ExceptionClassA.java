package ca.uwaterloo.cs.se.bench.simple;

public class ExceptionClassA {

	// a1->a2->a3
	// a2 throws exception; a1 catches, calls a4
	// a2->a3 never happens due to exception
	public void a1() {
		try {
			a2();
		} catch (Exception e) {
			a4();
		}
	}

	public void a2() {
		if (true)
			throw new RuntimeException();

		a3(); // should never happen
	}

	public void a3() {

	}

	public void a4() {

	}

	// b1->b2->b3->b4
	// b4 throws
	// b2 catches, calls b5
	public void b1() {
		b2();
	}

	public void b2() {
		try {
			b3();
		} catch (Exception e) {
			b5();
		}
	}

	public void b3() {
		b4();
	}

	public void b4() {
		throw new RuntimeException();
	}

	public void b5() {

	}

	// c1 -> c1 -> c1 (8 times)
	// c1 throws
	// c1 catches, calls c3
	public void c1() {
		try {
			for (int i = 0; i < 10; i++) {
				if (i == 8)
					throw new RuntimeException();
				c2();
			}
		} catch (Exception e) {
			c3();
		}
	}

	public void c2() {

	}

	public void c3() {

	}

}
