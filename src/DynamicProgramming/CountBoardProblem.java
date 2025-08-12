package DynamicProgramming;

public class CountBoardProblem {
    public static void main(String[] args) {
        int n=10;
        System.out.println(countBoardPathRecursive(0,n));
     //   System.out.println(countBoardPathTD(0,n,new int[n]));
        System.out.println(countBoardPathBU(n));
        System.out.println(countBoardPathBUSE(n));
    }

    //Time : o(6^n) Space : o(n)
    public static int countBoardPathRecursive(int current, int end){
        if (current==end){
            return 1;
        }
        if (current>end){
            return 0;
        }
        int count=0;
        for (int dice = 1; dice <=6 ; dice++) {
            count += countBoardPathRecursive(current+dice,end);
        }
        return count;
    }

    //Time : o(n) Space : o(n)
    public static int countBoardPathTD(int current, int end, int[] dp){
        if (current==end){
            return 1;
        }
        if (current>end){
            return 0;
        }
        if (dp[current]!=0) {
            return dp[current];
        }
        int count=0;
        for (int dice = 1; dice <=6 ; dice++) {
            count += countBoardPathTD(current+dice,end,dp);
        }
        dp[current]=count;
        return count;
    }


    //Time : o(n) Space : o(n)
    public static int countBoardPathBU(int end){
        int arr[] = new int[end+6];
        arr[end] = 1;
        for (int i = end-1; i >=0; i--) {
            arr[i] = arr[i+1]+arr[i+2]+arr[i+3]+arr[i+4]+arr[i+5]+arr[i+6];
        }
        return arr[0];
    }

    //Time : o(n) Space : o(1)
    public static int countBoardPathBUSE(int end){
        int arr[] = new int[6];
        arr[0] = 1;
        for(int slide=1;slide<=end;slide++){
            int sum = arr[0]+arr[1]+arr[2]+arr[3]+arr[4]+arr[5];
            arr[5] = arr[4];
            arr[4] = arr[3];
            arr[3] = arr[2];
            arr[2] = arr[1];
            arr[1] = arr[0];
            arr[0] = sum;
        }
        return arr[0];

    }
}
