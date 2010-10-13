package org.sudr.sandbox.junit;

public class ExceptionTestCase extends TestCase {

	public ExceptionTestCase(String name) {
		super(name);
	}
	
	@Override
	protected void runTest() {
		throw new RuntimeException();
	}

}
