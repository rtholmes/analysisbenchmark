package ca.uwaterloo.cs.se.bench.simple;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Vector;

public class SimpleThreadClass {

	class ThreadA extends Thread {

		private int count;

		private int tick = 1;

		public ThreadA(int iterations) {
			count = iterations;
		}

		public void run() {
			Vector<String> v = new Vector<String>();
			while (tick < count) {
				v.add(a());
				tick++;
				// System.out.println("A: " + tick);
			}
			for (String s : v) {
				if (!s.equals("a"))
					throw new RuntimeException("Threading Problem; a should only get 'b' chars: " + v);
			}
		}
	}

	class ThreadB extends Thread {

		private int count;

		private int tick = 1;

		public ThreadB(int iterations) {
			count = iterations;
		}

		public void run() {
			Vector<String> v = new Vector<String>();
			while (tick < count) {
				v.add(b());
				tick++;
				// System.out.println("B: " + tick);
			}
			for (String s : v) {
				if (!s.equals("b"))
					throw new RuntimeException("Threading Problem; b should only get 'b' chars: " + v);
			}
		}
	}

	private String a() {
		return compute("a");
	}

	private String b() {
		return compute("b");
	}

	/**
	 * This method is just obnoxious to take up computation time.
	 * 
	 * @param inputString
	 * @return
	 */
	private String compute(String inputString) {
		try {
			byte[] bytesOfMessage = inputString.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] output = md.digest(bytesOfMessage);
			String s = new String(output);
			try {
				// make things even slower
				Class.forName("java.lang.String");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return inputString;
	}

	public void run(int iterations) {
		ThreadA ta = new ThreadA(iterations);
		ThreadB tb = new ThreadB(iterations);

		// ThreadA.run(int) should only ever call a()
		ta.start();

		// ThreadB.run(int) should only ever call b()
		tb.start();

		try {
			ta.join();
			tb.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}