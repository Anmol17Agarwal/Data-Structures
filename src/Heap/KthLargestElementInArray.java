package Heap;

import java.util.PriorityQueue;

//LeetCode question number 215
public class KthLargestElementInArray {
    public static void main(String[] args) {
        int[] nums ={3,2,1,5,6,4};
        int k=2;
        KthLargestElementInArray kTh = new KthLargestElementInArray();
        System.out.println(kTh.findKthLargest(nums,k));
    }
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}


