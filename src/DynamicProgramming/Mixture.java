package DynamicProgramming;

public class Mixture {
    public static void main(String[] args) {
        int arr[] = {40,60,20,50};
        System.out.println(mixtureRecursive(arr, 0, arr.length - 1));
    }

    public static int mixtureRecursive(int[] arr, int start, int end) {
        if (start == end) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = start; k <= end - 1; k++) {
            int fp = mixtureRecursive(arr, start, k);
            int sp = mixtureRecursive(arr, k + 1, end);
            int sw = color(arr, start, k) * color(arr, k + 1, end);
            int total = (fp + sp + sw);
            if (total < min) {
                min = total;
            }
        }
        return min;
    }
    public static int color(int[] arr,int i,int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum+= arr[k];
        }
        return sum%100;
    }
}