package ca.uwaterloo.cs.se.bench.simple;

import java.util.Collection;
import java.util.Vector;

public class SimpleClass {

	private String fieldA;

	public void a1() {
		a2();
	}

	private void a2() {
	}

	public void b1() {
		b2();
	}

	private Vector b2() {
		Vector v = new Vector();
		return v;
	}

	public void c1() {
		c2("param");
	}

	private void c2(String string) {

	}

	public void d1() {
		int[] dArray = null;
		int[][] ddArray = null;

		d2("param", dArray, ddArray);
	}

	private void d2(String string, int[] dArray, int[][] ddArray) {

	}

	public void e1() {
		Vector v = new Vector();
		e2(v);
	}

	private void e2(Vector v) {

	}

	public void f1() {
		Vector v = new Vector();
		f2(v);
	}

	private void f2(Collection v) {

	}

	public void g1() {
		Collection c = new Vector();
		g2(c);
	}

	private void g2(Collection c) {
		// TODO Auto-generated method stub

	}

	public void h1() {
		String s = h2();
	}

	private String h2() {
		return "string";
	}

	public void i1() {
		Vector v = i2();
		v.size();
	}

	private Vector i2() {
		return new Vector();
	}

	public void j1() {
		Collection c = j2();
		c.size();
	}

	private Collection j2() {
		return new Vector();
	}

	public void k1() {
		Vector<String> v = new Vector<String>();
		k2(v);
	}

	private void k2(Vector<String> v) {

	}

	public void l1() {
		Collection<String> c = new Vector<String>();
		l2(c);
	}

	private void l2(Collection<String> c) {

	}

	public void m1() {
		m2("string", 1);
	}

	private boolean m2(String s, int i) {
		return true;
	}

	public void n0() {
		String f = fieldA;
	}
}
