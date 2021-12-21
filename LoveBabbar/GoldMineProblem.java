package LoveBabbar;

import java.util.Arrays;

public class GoldMineProblem {
    public static void main(String[] args) {
        int[][] arr = { {1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2} };
        System.out.println(maxGold(arr, 4, 4 ));
    }

    static int maxGold(int[][] arr, int n, int m) {
        int[][] dp = new int[n][m];

        for (int[] a : dp) Arrays.fill(a, 0);

        for (int c = m-1; c >=0 ; c--) {
            for (int r = 0; r < n; r++) {
                int rightPath = (c == m-1) ? 0 : dp[r][c+1];
                int rightUpPath = (c == m-1 || r==0) ? 0 : dp[r-1][c+1];
                int rightDownPath = (c == m-1 || r==n-1) ? 0 : dp[r+1][c+1];

                dp[r][c] = arr[r][c] + Math.max(rightPath, Math.max(rightDownPath, rightUpPath));
            }
        }

        int temp = dp[0][0];

        for (int i = 1; i < n; i++) {
            temp = Math.max(temp, dp[i][0]);
        }
        return temp;
    }
}
