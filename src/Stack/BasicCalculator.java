package Stack;

import java.util.Stack;
//LeetCode Question no 224
public class BasicCalculator {
        public int calculate(String s) {
            Stack<Integer> stack = new Stack<>();
            int result = 0;
            int num = 0;
            int sign = 1; // 1 means '+', -1 means '-'

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (Character.isDigit(ch)) {
                    num = num * 10 + (ch - '0');
                } else if (ch == '+') {
                    result += sign * num;
                    sign = 1;
                    num = 0;
                } else if (ch == '-') {
                    result += sign * num;
                    sign = -1;
                    num = 0;
                } else if (ch == '(') {
                    // Push current result and sign
                    stack.push(result);
                    stack.push(sign);
                    // Reset for new expression
                    result = 0;
                    sign = 1;
                } else if (ch == ')') {
                    result += sign * num;
                    num = 0;
                    // Apply the sign before the parenthesis
                    result *= stack.pop();
                    // Add to the result before the parenthesis
                    result += stack.pop();
                }
                // Skip spaces
            }

            result += sign * num; // Add any remaining number
            return result;
        }

    public static void main(String[] args) {
        BasicCalculator calc = new BasicCalculator();
        System.out.println(calc.calculate("1 + 1"));                // 2
        System.out.println(calc.calculate(" 2-1 + 2 "));            // 3
        System.out.println(calc.calculate("(1+(4+5+2)-3)+(6+8)"));  // 23
    }
    }
