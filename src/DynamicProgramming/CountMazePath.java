package DynamicProgramming;

import java.util.Arrays;

public class CountMazePath {
    public static void main(String[] args) {
        System.out.println(mazePathRecursive(0,0,2,2));
        System.out.println(mazePathTB(0,0,2,2,new int[3][3]));
        System.out.println(mazePathBU(2,2));
        System.out.println(mazePathBUSE(2,2));
    }

    // Time : O(2^(endRow*endColumn)) Space : Recursive Extra Space
    public static int mazePathRecursive(int currentRow, int currentColumn,int endRow, int endColumn){
        if(currentRow==endRow && currentColumn==endColumn){
            return 1;
        }
        if(currentRow>endRow || currentColumn>endColumn){
            return 0;
        }int count=0;
        count+=mazePathRecursive(currentRow,currentColumn+1,endRow,endColumn);
        count+=mazePathRecursive(currentRow+1,currentColumn,endRow,endColumn);
        return count;
    }


    // Time : O(endRow*endColumn) Space : O(endRow*endColumn)
    public static int mazePathTB(int currentRow, int currentColumn,int endRow, int endColumn,int[][] dp){
        if(currentRow==endRow && currentColumn==endColumn){
            return 1;
        }
        if(currentRow>endRow || currentColumn>endColumn){
            return 0;
        }
        if(dp[currentRow][currentColumn]!=0){
            return dp[currentRow][currentColumn];
        }
        int count=0;
        count+=mazePathTB(currentRow,currentColumn+1,endRow,endColumn,dp);
        count+=mazePathTB(currentRow+1,currentColumn,endRow,endColumn,dp);
        dp[currentRow][currentColumn]=count;
        return count;
    }

    // Time : O(endRow*endColumn) Space : O(endRow*endColumn)
    public static int mazePathBU(int endRow, int endColumn){
        int[][] dp = new int[endRow+1][endColumn+1];
        dp[endRow][endColumn]=1;
        for (int i = endRow-1; i >=0; i--) {
            for (int j = endColumn-1; j >=0; j--) {
                dp[i][j]=dp[i+1][j]+dp[i][j+1];
            }
        }
        return dp[0][0];
    }


    // Time : O(endRow*endColumn) Space : O(endColumn)
    public static int mazePathBUSE(int endRow, int endColumn){
        int[] dp = new int[endColumn+1];
        Arrays.fill(dp,1);
        for (int slide = endRow-1; slide >=0; slide--) {
            for (int col = endColumn; col >=0; col--) {
                    if(col == endColumn){
                        dp[col] = 1;
                    }
                    else{
                       dp[col] = dp[col]+dp[col+1];
                    }
            }
        }
        return dp[0];
    }
}
