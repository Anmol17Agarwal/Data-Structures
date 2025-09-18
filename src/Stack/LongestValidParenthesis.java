package Stack;
//LeetCode Question =  32
import java.util.Stack;

public class LongestValidParenthesis {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();

        stack.push(-1);

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();

                // If stack is empty, push the current index as a base for future calculations
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    // Calculate the length of the current valid parentheses
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }
}

/*
* For the input s = "(()())", the stack will operate like this:

First encounter '(': push 0 onto the stack.

Second encounter '(': push 1 onto the stack.

Encounter ')': pop 1 (valid pair with index 0). The length of the valid substring is i - stack.peek() = 2 - (-1) = 3.

Encounter '(': push 3 onto the stack.

Encounter ')': pop 3 (valid pair with index 0). The length of the valid substring is i - stack.peek() = 4 - (-1) = 4.

Encounter ')': pop -1 (valid pair with index 0). The length of the valid substring is i - stack.peek() = 5 - (-1) = 6.

Thus, the longest valid parentheses substring is 6.

Time Complexity:*/