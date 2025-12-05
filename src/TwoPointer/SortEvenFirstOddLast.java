package TwoPointer;

import java.util.Arrays;

public class SortEvenFirstOddLast {
    public static void main(String[] args) {
        int[] arr = {3,1,2,4};

        int i=0;
        int j=arr.length-1;
        while (i<j){
            if(arr[i]%2==0){
                i++;
            }else if (arr[j]%2!=0){
                j--;
            }else{
                swap(arr,i,j);
                i++;j--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
