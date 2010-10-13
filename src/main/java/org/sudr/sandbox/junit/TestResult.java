package org.sudr.sandbox.junit;

/**
 * Used in the Collecting parameter pattern
 */
public class TestResult {

	protected int countTests;
	
	public TestResult() {
		countTests = 0;
	}

	public synchronized void startTest(AbstractTestCase testCase) {
		countTests++;
	}

}
