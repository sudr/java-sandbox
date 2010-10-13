package org.sudr.sandbox.junit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class TestFrameworkSteps {

	private AbstractTestCase testCase;
	private TestResult result;

	@Given("a test case")
	public void aTestCase() {
		this.result = new TestResult();
		this.testCase = new SampleTestCase(getClass().toString());
	}

	@When("I call execute")
	public void iCallExecute() {
		testCase.run(result);
	}

	@Then("the test count should be $countTests")
	public void theResultShouldBe(int countTests) {
		assertThat(result.countTests, equalTo(countTests));
	}
	
}
