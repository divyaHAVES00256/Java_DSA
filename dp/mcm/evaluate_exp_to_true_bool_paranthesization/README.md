Evaluate Expression To True-Boolean Parenthesization Recursion
Given a boolean expression with following symbols.
Symbols
    'T' --- true 
    'F' --- false 
And following operators filled between symbols
Operators
    &   ---boolean AND
    |   --- boolean OR
    ^   --- boolean XOR 
Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.
Example:
Input: symbol[]    = {T, F, T}
       operator[]  = {^, &}
Output: 2
The given expression is "T ^ F & T", it evaluates true
in two ways "((T ^ F) & T)" and "(T ^ (F & T))"