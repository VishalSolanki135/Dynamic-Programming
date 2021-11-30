package Knapsack;

public class MinimumSubsetSumDiff {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 7};
        System.out.println(validValues(arr, arr.length));
    }

    static int validValues(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        boolean[][] dp = new boolean[n+1][sum+1];

        for (int i = 0; i <= n ; i++) {
            for (int j = 0; j <= sum; j++) {
                if(i==0) dp[i][j] = false;
                if(j==0) dp[i][j] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if(arr[i-1]<=j) dp[i][j] = dp[i-1][j] || dp[i-1][j - arr[i-1]];
                else dp[i][j] = dp[i-1][j];
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i <=sum/2 ; i++) {
            if(dp[n][i]) {
                min = Math.min(min, sum - 2 * i);
            }
        }
        return min;
    }
}
