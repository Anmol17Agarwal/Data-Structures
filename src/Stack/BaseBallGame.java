package Stack;

//LeetCode Question 682
import java.util.Stack;

public class BaseBallGame {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int total = 0;
        for (int i = 0; i < operations.length; i++) {
            if (isNumeric(operations[i])) {
                stack.push(Integer.parseInt(operations[i]));
            }
            if (operations[i].equals("+")) {
                int number1 = stack.peek();
                stack.pop();
                int number2 = stack.peek();
                int number3 = number1 + number2;
                stack.push(number1);
                stack.push(number3);
            }
            if (operations[i].equals("D")) {
                int number = stack.peek();
                stack.push(number * 2);
            }
            if (operations[i].equals("C")) {
                stack.pop();
            }
        }
        while (!stack.isEmpty()) {
            total += stack.pop();
        }
        return total;
    }

    public static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);  // Try parsing as an integer
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
