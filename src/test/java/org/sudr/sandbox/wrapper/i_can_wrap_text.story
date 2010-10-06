Given a text wrapper of line width 10
When I wrap an empty string
Then the result is empty

Given a text wrapper of line width 10
When I wrap the string The quick
Then the result is The quick

Given a text wrapper of line width 10
When I wrap the string The quick brown fox
Then the result is The quick
brown fox

Given a text wrapper of line width 9
When I wrap the string The quick brown
Then the result is The quick
brown

Given a text wrapper of line width 11
When I wrap the string The quick brown fox
Then the result is The quick
brown fox

Given a text wrapper of line width 10
When I wrap the string The quick brown fox jumps over the lazy dog
Then the result is The quick
brown fox
jumps over
the lazy
dog

Given a text wrapper of line width 2
When I wrap the string The
Then the result is Th
e

Given a text wrapper of line width 5
When I wrap the string TheQuickBrownFoxJumpsOverTheLazyDog
Then the result is TheQu
ickBr
ownFo
xJump
sOver
TheLa
zyDog
