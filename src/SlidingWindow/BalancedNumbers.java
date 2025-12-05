package SlidingWindow;
public class BalancedNumbers {
    public static void main(String[] args) {
        int[] arr = {1,7,3,6,5,6};

        int total = 0;
        for (int num : arr) total += num;

        int leftSum = 0;

        for (int i = 0; i < arr.length; i++) {
            int rightSum = total - leftSum - arr[i];

            if (leftSum == rightSum) {
                System.out.println(i);
                return;
            }

            leftSum += arr[i];
        }

        System.out.println("No balanced index");
    }
}
