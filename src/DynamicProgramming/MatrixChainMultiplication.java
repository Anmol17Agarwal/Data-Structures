package DynamicProgramming;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] arr = {4,2,3,5,1};
        System.out.println(matrixChainMultiplication(arr,0,arr.length-1));
    }
    public static int matrixChainMultiplication(int[] arr,int si, int ei) {
        if(si+1==ei) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int k=si+1;k<=ei-1;k++) {
            int fp = matrixChainMultiplication(arr,si,k);
            int sp = matrixChainMultiplication(arr,k,ei);
            int sw = arr[si]*arr[k]*arr[ei];
            int total = (fp+sp+sw);
            if(total<min) {
                min = total;
            }
        }
        return min;
    }

}
