package LoveBabbar;

import java.util.Arrays;

public class MinCostPath {
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(minPathSum(grid));
    }

    static int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        dp[0][0] = grid[0][0];
        for (int col = 1; col < m; col++) {
            dp[0][col] = dp[0][col-1] + grid[0][col];
        }

        for (int row = 1; row < n; row++) {
            dp[row][0] = dp[row-1][0] + grid[row][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[n-1][m-1];
    }
}
