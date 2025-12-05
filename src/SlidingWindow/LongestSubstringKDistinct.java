package SlidingWindow;
import java.util.HashMap;

public class LongestSubstringKDistinct {
    public static void main(String[] args) {
        String s1="eceba";
        String s = "eceeeeeeba";
        int k = 2;

        int left = 0, maxLen = 0;
        HashMap<Character, Integer> freq = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

            // shrink window until we have at most k distinct characters
            while (freq.size() > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);

                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
                left++; // shrink the window
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        System.out.println(maxLen);
    }
}
