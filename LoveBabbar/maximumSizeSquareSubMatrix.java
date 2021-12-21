package LoveBabbar;

import java.util.Arrays;

public class maximumSizeSquareSubMatrix {
    public static void main(String[] args) {
        char[][] matrix = {{'0', '1', '1', '0', '1'},
                {'1', '1', '0', '1', '0'},
                {'0', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1'},
                {'0', '0', '0', '0', '0'}};

        System.out.println(maximalSquare(matrix));
    }

    static int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        // first row will remain same
        for (int i = 0; i < m; i++) {
            dp[0][i] = Integer.parseInt(String.valueOf(matrix[0][i]));
        }

        // first column will remain same
        for (int i = 0; i < n; i++) {
            dp[i][0] = Integer.parseInt(String.valueOf(matrix[i][0]));
        }

        // code based on the previous answer or values

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(matrix[i][j] == '1') {
                    dp[i][j] =  Math.min(dp[i][j-1], Math.min(dp[i-1][j-1], dp[i-1][j])) + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max*max;
    }
}
