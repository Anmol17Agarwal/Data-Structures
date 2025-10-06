package Extra;

import java.util.ArrayList;
import java.util.List;

//Leetcode question number - 3507
public class MinimumPairRemovalToSort {

    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        System.out.println(minimumPairRemoval(nums));
        int[] nums1 = {1,2,2};
        System.out.println(minimumPairRemoval(nums1));
    }
        public static int minimumPairRemoval(int[] nums) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums) list.add(n);

            int operations = 0;

            while (!isNonDecreasing(list)) {
                int minSum = Integer.MAX_VALUE;
                int minIndex = -1;

                // Find the leftmost pair with minimum sum
                for (int i = 0; i < list.size() - 1; i++) {
                    int sum = list.get(i) + list.get(i + 1);
                    if (sum < minSum) {
                        minSum = sum;
                        minIndex = i;
                    }
                }

                // Merge the pair at minIndex
                int merged = list.get(minIndex) + list.get(minIndex + 1);
                list.set(minIndex, merged);
                list.remove(minIndex + 1);

                operations++;
            }

            return operations;
        }
        private static boolean isNonDecreasing(List<Integer> list) {
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) < list.get(i - 1)) {
                    return false;
                }
            }
            return true;
        }
}
