package org.sudr.sandbox.junit;


public class AssertionErrorTestCase extends TestCase {

	public AssertionErrorTestCase(String name) {
		super(name);
	}

	@Override
	protected void runTest() {
		assertThat(false);
	}

}
