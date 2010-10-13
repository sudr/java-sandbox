Given a test case
When I call execute
Then the test count should be 1

Given a test case that throws assertion error
When I call execute
Then the failure count should be 1

Given a test case that throws an exception
When I call execute
Then the error count should be 1

Given a test case that declares a public method
When I call execute
Then the test count should be 1

Given a test suite with 2 tests
When I call execute on the test suite
Then the test suite result count should be 2