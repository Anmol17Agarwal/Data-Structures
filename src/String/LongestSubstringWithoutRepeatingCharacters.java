package String;
import java.util.HashMap;

//Leetcode problem number 3
public class LongestSubstringWithoutRepeatingCharacters {
        public static int lengthOfLongestSubstring(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            int maxLength = 0;
            int start = 0; // left boundary of sliding window

            for (int end = 0; end < s.length(); end++) {
                char currentChar = s.charAt(end);

                // If the character is already in the map and its index is >= start,
                // move the start to one position after the previous index of that char.
                if (map.containsKey(currentChar) && map.get(currentChar) >= start) {
                    start = map.get(currentChar) + 1;
                }

                // Update the latest index of the current character
                map.put(currentChar, end);

                // Calculate window size
                maxLength = Math.max(maxLength, end - start + 1);
            }

            return maxLength;
        }

        // Test the function
        public static void main(String[] args) {
            System.out.println(lengthOfLongestSubstring("abcabcbb")); // Output: 3
            System.out.println(lengthOfLongestSubstring("bbbbb"));    // Output: 1
            System.out.println(lengthOfLongestSubstring("pwwkew"));   // Output: 3
            System.out.println(lengthOfLongestSubstring(""));         // Output: 0
            System.out.println(lengthOfLongestSubstring("dvdf"));     // Output: 3
        }
    }
