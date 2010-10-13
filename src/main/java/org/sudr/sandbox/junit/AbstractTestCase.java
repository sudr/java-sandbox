package org.sudr.sandbox.junit;

public abstract class AbstractTestCase {

	private final String name;
	
	public AbstractTestCase(String name) {
		this.name = name;
	}
	
	/**
	 * Command Pattern
	 * Template Method Pattern
	 */
	public void run(TestResult result) {
		result.startTest(this);
		setUp();
		runTest();
		tearDown();
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

}
