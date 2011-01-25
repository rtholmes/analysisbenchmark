package ca.uwaterloo.cs.se.bench.simple;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class SimpleThreadClass {

	class ThreadA extends Thread {

		private int count;

		private int tick = 1;

		public ThreadA(int iterations) {
			count = iterations;
		}

		public void run() {
			while (tick < count) {
				a();
				tick++;
				// System.out.println("A: " + tick);
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
			while (tick < count) {
				b();
				tick++;
				// System.out.println("B: " + tick);
			}
		}
	}

	private void a() {
		String timeString = new Date().getTime() + "";
		compute(timeString);
		// System.out.println("a");
	}

	private void b() {
		String timeString = new Date().getTime() + "";
		compute(timeString);
		// F System.out.println("b");
	}

	private void compute(String timeString) {
		try {
			byte[] bytesOfMessage = timeString.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] output = md.digest(bytesOfMessage);
			String s = new String(output);
			try {
				// make things even slower
				Class.forName("java.lang.String");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
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