package org.sudr.sandbox.junit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class TestFrameworkSteps {

	private TestCase testCase;
	private TestSuite testSuite;
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
	
	@Given("a test case that throws an exception")
	public void aTestCaseThatThrowsAnException() {
		this.result = new TestResult();
		this.testCase = new ExceptionTestCase(getClass().toString());
	}

	@Given("a test case that declares a public method")
	public void aTestCaseThatDeclaresPublicMethod() {
		this.result = new TestResult();
		this.testCase = new PublicMethodTestCase(getClass().toString());
	}
	
	@Given("a test suite with 2 tests")
	public void aTestSuiteWithTests() {
		this.result = new TestResult();
		this.testSuite = new TestSuite();
		testSuite.addTest(new PublicMethodTestCase("testMethod1"));
		testSuite.addTest(new PublicMethodTestCase("testMethod2"));
	}
	
	@When("I call execute")
	public void iCallExecute() {
		testCase.run(result);
	}
	
	@When("I call execute on the test suite")
	public void iCallExecuteOnTheTestSuite() {
		testSuite.run(result);
	}

	@Then("the test count should be $testCount")
	public void theTestCountShouldBe(int testCount) {
		assertThat(result.countTests, equalTo(testCount));
	}
	
	@Then("the test suite result count should be $testCount")
	public void theTestSuiteResultCountShouldBe(int testCount) {
		assertThat(result.countTests, equalTo(testCount));
	}
	
	@Then("the failure count should be $failureCount")
	public void theFailureCountShouldBe(int failureCount) {
		assertThat(result.failureCount(), equalTo(failureCount));
	}
	
	@Then("the error count should be $errorCount")
	public void theErrorCountShouldBe(int errorCount) {
		assertThat(result.errorCount(), equalTo(errorCount));
	}
	
}
