package MatrixChainMultiplication;

import java.util.Arrays;

public class MemoizationBottomUp {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 3};
        System.out.println(solve(arr, 1, arr.length-1));
    }

    static int solve(int[] arr, int i, int j) {
        if(i>=j) return 0;

        int[][] dp = new int[i+1][j+1];
        for (int[] a : dp) Arrays.fill(a, -1);
        
        if(dp[i][j]!=-1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int k = i; k <=j-1 ; k++) {
            int temp = solve(arr, i, k) + solve(arr, k+1, j) + arr[i-1]*arr[k]*arr[j];
            if(temp < min) min = temp;
        }
        dp[i][j] = min;
        return dp[i][j];
    }
}
