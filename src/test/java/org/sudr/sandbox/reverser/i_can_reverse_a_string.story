Given a string reverser
When I reverse an "" string
Then the result should be ""

Given a string reverser
When I reverse the string A
Then the result should be A

Given a string reverser
When I reverse the string AB
Then the result should be BA

Given a string reverser
When I reverse the string ABC
Then the result should be CBA

Given a string reverser
When I reverse the string ABA
Then the result should be ABA

Given a string reverser
When I do not provide a string
Then I should get back empty