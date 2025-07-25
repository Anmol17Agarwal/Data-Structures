package DynamicProgramming;

public class KnapsackProblem {
    public static void main(String[] args) {
        int[] weight = {1,3,4,5};
        int[] price = {1,4,5,7};
        int capacity = 7;
        System.out.println(knapsack(weight,price,0,capacity));
        int[][] dp = new int[weight.length][capacity+1];
        System.out.println(knapsackTB(weight,price,0,capacity,dp));
        System.out.println(knapsackBU(weight,price,capacity));
    }
    public static int knapsack(int[] weight, int[] price,int vidx,int capacity) {

        //base case
        if(vidx==weight.length || capacity==0) {
            return 0;
        }
        //include
        int include =0;
        if(weight[vidx]<=capacity)
            include = knapsack(weight,price,vidx+1,capacity-weight[vidx]) + price[vidx];

        //exclude
        int exclude = knapsack(weight,price,vidx+1,capacity);

        return Math.max(include,exclude);

    }
    public static int knapsackTB(int[] weight, int[] price,int vidx,int capacity,int[][] dp) {

        //base case
        if(vidx==weight.length || capacity==0) {
            return 0;
        }
        if(dp[vidx][capacity] != 0) {
            return dp[vidx][capacity];
        }
        //include
        int include =0;
        if(weight[vidx]<=capacity)
            include = knapsackTB(weight,price,vidx+1,capacity-weight[vidx],dp) + price[vidx];

        //exclude
        int exclude = knapsackTB(weight,price,vidx+1,capacity,dp);

        dp[vidx][capacity] = Math.max(include,exclude);
        return Math.max(include,exclude);

    }

    public static int knapsackBU(int[] weight, int[] price,int capacity) {
        int[][] dp = new int[weight.length+1][capacity+1];
        for(int row=weight.length-1;row>=0;row--) {
            for(int col=1;col<=capacity;col++) {
                int include =0;
                if(weight[row]<=col)
                    include = dp[row+1][col-weight[row]] + price[row];
                int exclude = dp[row+1][col];
                dp[row][col] = Math.max(include,exclude);
            }
        }
        return dp[0][capacity];
    }
}
