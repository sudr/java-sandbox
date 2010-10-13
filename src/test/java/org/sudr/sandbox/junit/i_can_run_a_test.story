Given a test case
When I call execute
Then the test count should be 1

Given a test case that throws assertion error
When I call execute
Then the failure count should be 1

Given a test case that throws an exception
When I call execute
Then the error count should be 1