package org.sudr.sandbox.junit;

public class TestFailure {

	private final Test test;
	private final Throwable t;

	public TestFailure(Test test, Throwable t) {
		this.test = test;
		this.t = t;
	}

}
