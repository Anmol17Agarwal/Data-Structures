package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle{
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(minimumTotal(triangle));
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] memo = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(memo[i][j]+"\t");
            }
            System.out.println();
        }


        return helper(0, 0, triangle, memo);
    }

    private static int helper(int row, int col, List<List<Integer>> triangle, int[][] memo) {
        int n = triangle.size();

        if (row == n - 1) {
            return triangle.get(row).get(col);
        }

        if (memo[row][col] != Integer.MAX_VALUE) {
            return memo[row][col];
        }

        int down = helper(row + 1, col, triangle, memo);
        int diagonal = helper(row + 1, col + 1, triangle, memo);

        memo[row][col] = triangle.get(row).get(col) + Math.min(down, diagonal);
        System.out.println(memo[row][col]);
        return memo[row][col];
    }
}
