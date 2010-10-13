package org.sudr.sandbox.junit;

import java.util.ArrayList;
import java.util.List;

public class TestSuite implements Test {

	private List<Test> tests = new ArrayList<Test>();
	
	public void run(TestResult result) {
		for (Test t : tests) {
			t.run(result);
		}
	}
	
	public void addTest(Test test) {
		tests.add(test);
	}

}
