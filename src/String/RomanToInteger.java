package String;

import java.util.HashMap;

//Leetcode question number 13
public class RomanToInteger {
    public int romanToInt(String s) {
        HashMap<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
        int previous = 0;
        int total = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int current = roman.get(s.charAt(i));
            if (current < previous) {
                total -= current;
            } else {
                total += current;
            }
            previous = current;
        }
        return total;
    }
}

