package org.sudr.sandbox.junit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class TestCase implements Test {

	private final String name;

	public TestCase(String name) {
		this.name = name;
	}

	/**
	 * Command Pattern; Template Method Pattern
	 */
	public void run(TestResult result) {
		result.startTest(this);
		setUp();
		try {
			runTest();
		} catch (AssertionFailedError e) {
			result.addFailure(this, e);
		} catch (Throwable t) {
			result.addError(this, t);
		} finally {
			tearDown();
		}
	}

	public TestResult run() {
		TestResult result = createTestResult();
		run(result);
		return result;
	}

	protected void runTest() throws Throwable {
		Method runMethod = null;
		try {
			runMethod = getClass().getMethod(name, new Class[0]);
		} catch (NoSuchMethodException e) {
			assertTrue("Method \"" + name + "\" not found", false);
		}
		try {
			runMethod.invoke(this, new Class[0]);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	private TestResult createTestResult() {
		return new TestResult();
	}

	protected void setUp() {
	}

	protected void tearDown() {
	}

	protected void assertThat(boolean condition) {
		if (!condition) {
			throw new AssertionFailedError();
		}
	}

	private void assertTrue(String string, boolean condition) {
		if (!condition) {
			throw new AssertionFailedError(string);
		}
	}

}
