package org.sudr.sandbox.junit;

@SuppressWarnings("serial")
public class AssertionFailedError extends Error {

	public AssertionFailedError(String message) {
		super(message);
	}

	public AssertionFailedError() {
	}

}
