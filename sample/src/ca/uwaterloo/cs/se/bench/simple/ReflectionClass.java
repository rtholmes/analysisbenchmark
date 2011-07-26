package ca.uwaterloo.cs.se.bench.simple;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Vector;

public class ReflectionClass {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	void instantiateString() {
		try {
			Class cls = Class.forName("java.lang.String");

			Class partypes[] = new Class[1];
			partypes[0] = cls;

			Constructor ct = cls.getConstructor(cls);

			Object strObj = ct.newInstance("param0");

			Method lengthMethod = cls.getMethod("length");
			Object output = lengthMethod.invoke(strObj);
			int length = ((Integer) output);

			if (length != 6) {
				throw new RuntimeException("reflection didn't work");
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	void callVectorAddAndSize() {

		try {
			Class cls = Class.forName("java.util.Vector");

			Object vector = cls.newInstance();

			((Vector) vector).add("foo");

			int size = ((Vector) vector).size();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	// TODO: try getting / setting fields via reflection
}
