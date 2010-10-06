package org.sudr.sandbox.wrapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.apache.commons.lang.StringUtils;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class WrapperSteps {

	private Wrapper wrapper;
	private String wrappedText;

	@Given("a text wrapper of line width $lineWidth")
	public void aStringReverser(int lineWidth) {
		this.wrapper = new Wrapper(lineWidth);
	}
	
	@When("I wrap the string $inputString")
	public void iWrapTheText(@Named("inputString")String inputString) {
		wrappedText = wrapper.wrap(inputString);
	}
	
	@When("I wrap an empty string")
	public void iWrapAnEmptyString() {
		wrappedText = wrapper.wrap("");
	}
	
	@Then("the result is empty")
	public void theResultIsEmpty() {
		assertThat(this.wrappedText, equalTo(StringUtils.EMPTY));
	}
	
	@Then("the result is $wrappedText")
	public void theResultIs(@Named("wrappedText")String wrappedText) {
		assertThat(this.wrappedText, equalTo(wrappedText));
	}
	
	
}
