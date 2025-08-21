package DynamicProgramming;

public class ClimbingStairs {
    static int count=0;
    public static void main(String[] args) {
        System.out.println(climbingStairsRecursive(5));
        System.out.println(climbingStairsRecursiveTD(45,new int[46]));
    }
    public static int climbingStairsRecursive(int n){
        if(n==0 || n==1){
            return 1;
        }
         return climbingStairsRecursive(n-1) + climbingStairsRecursive(n-2);
    }

    public static int climbingStairsRecursiveTD(int n,int[] dp){
        if(n==0 || n==1){
            return 1;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        dp[n]= climbingStairsRecursive(n-1) + climbingStairsRecursive(n-2);
        return dp[n];
    }
}
