package Heap;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) {
        Solution heap = new Solution();
        Scanner sc = new Scanner(System.in);
        int numberOfQueries = sc.nextInt();
        int kthDistance = sc.nextInt();
        for (int i = 0; i < numberOfQueries; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                int xCoordinate = sc.nextInt();
                int yCoordinate = sc.nextInt();
                int distance = xCoordinate * xCoordinate + yCoordinate * yCoordinate;
                heap.add(distance);
                heap.displayDistance();
            }
            if (type == 2) {
                System.out.println(heap.getKth(kthDistance));
            }
        }
    }


    private void displayDistance() {
        System.out.println(arr);
    }

    public void add(int data) {
        arr.add(data);
        upHeapify(arr.size() - 1);
    }

    private void upHeapify(int ci) {
        int pi = (ci - 1) / 2;
        if (arr.get(ci) < arr.get(pi)) {
            swap(pi, ci);
        }
    }

    private void swap(int i, int j) {
        int ithValue = arr.get(i);
        int jthValue = arr.get(j);
        arr.set(i, jthValue);
        arr.set(j, ithValue);
    }

    private int size() {
        return this.arr.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int getKth(int k) {
        return this.arr.get(k - 1);
    }
}


