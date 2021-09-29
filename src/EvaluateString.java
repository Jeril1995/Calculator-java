import java.util.*;

public class EvaluateString {
	public static double evaluate(String expression)
    {
        char[] tokens = expression.toCharArray();
 
         // Stack for numbers: 'values'
        Stack<Double> values = new
                              Stack<Double>();
 
        // Stack for Operators: 'ops'
        Stack<Character> ops = new
                              Stack<Character>();
 
        for (int i = 0; i < tokens.length; i++)
        {
             
            // Current token is a
            // whitespace, skip it
            if (tokens[i] == ' ')
                continue;
 
            // Current token is a number,
            // push it to stack for numbers
            if ((tokens[i] >= '0' &&
                 tokens[i] <= '9') || tokens[i] == '.')
            {
                StringBuffer sbuf = new
                            StringBuffer();
                 
                // There may be more than one
                // digits in number
                while (i < tokens.length &&
                        ((tokens[i] >= '0' &&
                          tokens[i] <= '9') || tokens[i] == '.'))
                    sbuf.append(tokens[i++]);
                values.push(Double.parseDouble(sbuf.
                                      toString()));
               
                // right now the i points to
                // the character next to the digit,
                // since the for loop also increases
                // the i, we would skip one
                //  token position; we need to
                // decrease the value of i by 1 to
                // correct the offset.
                  i--;
            }
 
            // Current token is an opening brace,
            // push it to 'ops'
            else if (tokens[i] == '(')
                ops.push(tokens[i]);
 
            // Closing brace encountered,
            // solve entire brace
            else if (tokens[i] == ')')
            {
                while (ops.peek() != '(')
                  values.push(applyOp(ops.pop(),
                                   values.pop(),
                                 values.pop()));
                ops.pop();
            }
 
            // Current token is an operator.
            else if (tokens[i] == '+' ||
                     tokens[i] == '-' ||
                     tokens[i] == '*' ||
                        tokens[i] == '/')
            {
                // While top of 'ops' has same
                // or greater precedence to current
                // token, which is an operator.
                // Apply operator on top of 'ops'
                // to top two elements in values stack
                while (!ops.empty() &&
                       hasPrecedence(tokens[i],
                                    ops.peek()))
                  values.push(applyOp(ops.pop(),
                                   values.pop(),
                                 values.pop()));
 
                // Push current token to 'ops'.
                ops.push(tokens[i]);
            }
        }
 
        // Entire expression has been
        // parsed at this point, apply remaining
        // ops to remaining values
        while (!ops.empty())
            values.push(applyOp(ops.pop(),
                             values.pop(),
                           values.pop()));
 
        // Top of 'values' contains
        // result, return it
        return values.pop();
    }
 
    // Returns true if 'op2' has higher
    // or same precedence as 'op1',
    // otherwise returns false.
    public static boolean hasPrecedence(
                           char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') &&
            (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
 
    // A utility method to apply an
    // operator 'op' on operands 'a'
    // and 'b'. Return the result.
    public static double applyOp(char op,
                           double b, double a)
    {
        switch (op)
        {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0.0)
                throw new
                UnsupportedOperationException(
                      "Cannot divide by zero");
            return a / b;
        }
        return 0.0;
    }
    
    public static char endOfString(String str) {
    	int n = str.length();
    	if(n == 0)
    		return '\0';
    	char last = str.charAt(n - 1);
    	return last;
    }
    
    public static boolean areBracketsBalanced(String expr)
    {
        // Using ArrayDeque is faster than using Stack class
        Deque<Character> stack
            = new ArrayDeque<Character>();
 
        // Traversing the Expression
        for (int i = 0; i < expr.length(); i++)
        {
            char x = expr.charAt(i);
 
            if (x == '(')
            {
                // Push the element in the stack
                stack.push(x);
                continue;
            }else if(x == ')') {
            	if(stack.isEmpty()) 
            		return false;
            	else
            		stack.pop();
            }
        }
 
        return (stack.isEmpty());
    }
}
