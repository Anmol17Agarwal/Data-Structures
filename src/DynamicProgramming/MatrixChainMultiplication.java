package DynamicProgramming;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] arr = {4,2,3,5,1,5,6,7,8,9,4,5,7,3,2};
//        System.out.println(matrixChainMultiplication(arr,0,arr.length-1));
        int[][] dp = new int[arr.length][arr.length];
        System.out.println(matrixChainMultiplicationTB(arr,0,arr.length-1,dp));
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
    public static int matrixChainMultiplicationTB(int[] arr,int si, int ei,int[][] dp) {
        if(si+1==ei) {
            return 0;
        }
        if(dp[si][ei]!=0) {
            return dp[si][ei];
        }
        int min = Integer.MAX_VALUE;
        for(int k=si+1;k<=ei-1;k++) {
            int fp = matrixChainMultiplicationTB(arr,si,k,dp);
            int sp = matrixChainMultiplicationTB(arr,k,ei,dp);
            int sw = arr[si]*arr[k]*arr[ei];
            int total = (fp+sp+sw);
            if(total<min) {
                min = total;
            }
            dp[si][ei] = min;
        }
        return min;
    }

}
