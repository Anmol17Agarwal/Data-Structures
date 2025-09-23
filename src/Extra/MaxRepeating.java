package Extra;

//Leetcode question no 1668
public class MaxRepeating {
    public static int maxRepeating(String sequence, String word) {
            int count = 0;
            String repeated = word;

            // Keep appending word and check if it's still a substring
            while (sequence.contains(repeated)) {
                count++;
                repeated += word;
            }

            return count;
    }

    public static void main(String[] args) {
        String s1= "abababac";
        String s2="ab";
        int count = maxRepeating(s1,s2);
        System.out.println(count);
    }
}
