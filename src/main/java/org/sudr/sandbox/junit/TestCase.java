package org.sudr.sandbox.junit;

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

	private TestResult createTestResult() {
		return new TestResult();
	}

	protected void setUp() {
	}

	protected void runTest() {
	}

	protected void tearDown() {
	}

	protected void assertThat(boolean condition) {
		if (!condition) {
			throw new AssertionFailedError();
		}
	}
}
