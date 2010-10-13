package org.sudr.sandbox.junit;

import java.util.ArrayList;
import java.util.List;



/**
 * Used in the Collecting parameter pattern
 */
public class TestResult {

	protected int countTests;
	private List<TestFailure> failures = new ArrayList<TestFailure>();
	
	public TestResult() {
		countTests = 0;
	}

	public synchronized void startTest(TestCase testCase) {
		countTests++;
	}

	public synchronized void addFailure(Test test, Throwable t) {
		failures.add(new TestFailure(test, t));
	}
	
	protected int failureCount() {
		return failures.size();
	}

}
