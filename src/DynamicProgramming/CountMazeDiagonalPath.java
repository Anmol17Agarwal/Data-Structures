package DynamicProgramming;

import java.util.Arrays;

public class CountMazeDiagonalPath {
    public static void main(String[] args) {
        int n=2;
//        System.out.println(mazePathDiagonalRecursive(0,0,n,n));
//        System.out.println(mazePathDiagonalTB(0,0,n,n,new int[n+1][n+1]));
        System.out.println(mazePathDiagonalBU(n,n));
//        System.out.println(mazePathBUSE(n,n)
    }

    // Time : O(3^(er*ec)) Space : Recursive Extra Space
    public static int mazePathDiagonalRecursive(int sr, int sc, int er, int ec) {
        if (sr == er && sc == ec) {
            return 1;
        }
        if (sr > er || sc > ec) {
            return 0;
        }
        int count = 0;
        count += mazePathDiagonalRecursive(sr, sc + 1, er, ec);
        count += mazePathDiagonalRecursive(sr + 1, sc, er, ec);
        count += mazePathDiagonalRecursive(sr + 1, sc + 1, er, ec);
        return count;
    }

    // Time : O(er*ec) Space : O(er*ec)
    public static int mazePathDiagonalTB(int sr, int sc, int er, int ec, int[][] dp) {
        if (sr == er && sc == ec) {
            return 1;
        }
        if (sr > er || sc > ec) {
            return 0;
        }
        if(dp[er][ec]!=0){
            return dp[er][ec];
        }
        int count = 0;
        count += mazePathDiagonalTB(sr, sc + 1, er, ec,dp);
        count += mazePathDiagonalTB(sr + 1, sc, er, ec,dp);
        count += mazePathDiagonalTB(sr + 1, sc + 1, er, ec,dp);
        dp[sr][sc] = count;
        return count;
    }

    // Time : O(er*ec) Space : O(er*ec)
    public static int mazePathDiagonalBU(int er, int ec) {
        int[][] dp = new int[er + 2][ec + 2];
        for (int i = er; i >= 0; i--) {
            for (int j = ec; j >= 0; j--) {
                if(i==er && j==ec){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1] + dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

}
