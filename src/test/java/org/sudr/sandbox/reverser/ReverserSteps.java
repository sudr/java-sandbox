package org.sudr.sandbox.reverser;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class ReverserSteps {

	private Reverser<String> stringReverser;
	private String reversedString;

	@Given("a string reverser")
	public void aStringReverser() {
		this.stringReverser = new StringReverser();
	}

	@When("I reverse a string <inputString>")
	@Aliases(values={"I reverse a $inputString string",
						"I reverse an $inputString string",
						"I reverse the $inputString string",
						"I reverse the string $inputString"})
	public void iReverseAInputString(@Named("inputString")String inputString) {
		reversedString = setupReverser(inputString);
	}

	private String setupReverser(String inputString) {
		return stringReverser.reverse(inputString);
	}

	@Then("the result should be <reversedString>")
	@Aliases(values = {"the result should be $reversedString"})
	public void theResultShouldBe(@Named("reversedString")String reversedString) {
		assertThat(this.reversedString, equalTo(reversedString));
	}
	
	@When("I do not provide a string")
	public void iDoNotProvideAString() {
		reversedString = setupReverser(null);
	}
	
	@Then("I should get back empty")
	public void iShouldGetBackEmpty() {
		assertThat(this.reversedString, equalTo(null));
	}

}
