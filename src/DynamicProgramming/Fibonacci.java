package DynamicProgramming;

public class Fibonacci {
    public static void main(String[] args) {
      //  System.out.println(fibRecursive(100000));
      //  System.out.println(fibTD(100000, new int[100001]));
        System.out.println(fibBU(100000));
    }

    //Time : O(2^n) Space : Recursive Extra Space
    public static int fibRecursive(int n) {
        if(n==0 || n==1) {
            return n;
        }
        return fibRecursive(n-1) + fibRecursive(n-2);
    }


    //Time : O(n) Space : O(n) + Recursive Extra Space
    public static int fibTD(int n, int[] dp) {
        if(n==0 || n==1) {
            return n;
        }
        if(dp[n] != 0) {
            return dp[n];
        }
        dp[n] = fibTD(n-1, dp) + fibTD(n-2, dp);
        return dp[n];
    }

    //Time : O(n) Space : O(n)
    public static int fibBU(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
