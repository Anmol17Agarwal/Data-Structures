package DynamicProgramming;

public class WineProblem {
    public static void main(String[] args) {
        int arr[] = {2,3,5,1,4};
        System.out.println(wineRecursive(arr,0,arr.length-1,1));
        int[][] dp = new int[arr.length][arr.length];
        System.out.println(wineTB(arr,0,arr.length-1,1,dp));
    }

    public static int wineRecursive(int[] arr,int start,int end,int year) {
        if(start==end) {
            return arr[start]*year;
        }
        int left = wineRecursive(arr,start+1,end,year+1) + arr[start]*year;
        int right = wineRecursive(arr,start,end-1,year+1) + arr[end]*year;
        return Math.max(left,right);
    }
    public static int wineTB(int[] arr,int start,int end,int year,int[][] dp) {
        if(start==end) {
            return arr[start]*year;
        }
        if(dp[start][end]!=0) {
            return dp[start][end];
        }
        int left = wineTB(arr,start+1,end,year+1,dp) + arr[start]*year;
        int right = wineTB(arr,start,end-1,year+1,dp) + arr[end]*year;
        dp[start][end]  = Math.max(left,right);
        return Math.max(left,right);
    }
}
