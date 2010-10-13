package org.sudr.sandbox.junit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class TestFrameworkSteps {

	private TestCase testCase;
	private TestResult result;

	@Given("a test case")
	public void aTestCase() {
		this.result = new TestResult();
		this.testCase = new SampleTestCase(getClass().toString());
	}
	
	@Given("a test case that throws assertion error")
	public void aTestCaseThatThrowsAssertionError() {
		this.result = new TestResult();
		this.testCase = new AssertionErrorTestCase(getClass().toString());
	}

	@When("I call execute")
	public void iCallExecute() {
		testCase.run(result);
	}

	@Then("the test count should be $testCount")
	public void theTestCountShouldBe(int testCount) {
		assertThat(result.countTests, equalTo(testCount));
	}
	
	@Then("the failure count should be $failureCount")
	public void theFailureCountShouldBe(int failureCount) {
		assertThat(result.failureCount(), equalTo(failureCount));
	}
	
}
