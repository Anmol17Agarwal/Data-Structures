package SlidingWindow;

import LInkedList.Main;

public class FindMaxSumOfSubArray {
    //Time complexity = O(n * k)
    //Hard-coded: fixed for size 3
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
/*        int sum=0;
        for (int i = 0; i < arr.length-k+1 ; i++) {
            int temp = arr[i]+arr[i+1]+arr[i+2];
            if(sum<temp)
                sum=temp;
        }
        System.out.println(sum);
    }*/
        //we will use sliding window to get output in order of O(n)

        int windowSum = 0;
        int maxSum = 0;
        int left = 0;

        for (int right = 0; right < arr.length; right++) {
            windowSum += arr[right];

            if (right - left + 1 == k) {
                maxSum = Math.max(windowSum, maxSum);
                windowSum -= arr[left];
                left++;
            }
        }
        System.out.println(maxSum);
    }
}
