package Stack;

import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        String str = "{{{(a+b)}}}";
        System.out.println(isBalanced(str));
    }
    public static boolean isBalanced(String str){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='{' || str.charAt(i)=='(' || str.charAt(i)=='[')
            {
                stack.push(str.charAt(i));
            }
            else if((str.charAt(i)=='}' || str.charAt(i)==')' || str.charAt(i)==']')) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (str.charAt(i) == '}') {
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
                if (str.charAt(i) == ')') {
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
                if (str.charAt(i) == ']') {
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
            else {
                continue;
            }
    }if(stack.isEmpty()){
        return true;
        }else{
            return false;
        }
    }
}
