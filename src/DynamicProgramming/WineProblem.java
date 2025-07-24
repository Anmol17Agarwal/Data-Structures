package DynamicProgramming;

public class WineProblem {
    public static void main(String[] args) {
        int arr[] = {2,3,5,1,4};
//        System.out.println();
        int sum = maxProfit(arr,0,arr.length-1,1);
        System.out.println(sum);
    }

    public static int maxProfit(int[] arr,int start,int end,int year) {
        if(start==end) {
            return arr[start]*year;
        }
        int left = maxProfit(arr,start+1,end,year+1) + arr[start]*year;
        int right = maxProfit(arr,start,end-1,year+1) + arr[end]*year;
        return Math.max(left,right);
    }
}
