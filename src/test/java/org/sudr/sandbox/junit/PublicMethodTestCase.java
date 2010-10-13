package org.sudr.sandbox.junit;

public class PublicMethodTestCase extends TestCase {

	public PublicMethodTestCase(String name) {
		super(name);
	}
	
	public void testSampleTestMethod() {
		assertThat(true);
	}

}
