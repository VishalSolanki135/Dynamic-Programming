package Knapsack;

public class KnapsackTopDown {
    public static void main(String[] args) {
        int val[] = new int[] {60, 100, 120};
        int wt[] = new int[] {10, 20, 30};
        int w = 50;
        int n = val.length;
        System.out.println(knapsack(wt, val, w, n));
    }

    static int knapsack(int[] wt, int[] val, int w, int n) {
        int[][] dp = new int[n+1][w+1];
        // initializing the dp array for satisfying the base condition
        for (int i = 0; i <=n; i++) {
            for (int j = 0; j <= n; j++) {
                if(i==0 || j==0) dp[i][j] = 0;
            }
        }

        // code based on choice
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if(wt[i-1] <= j) {
                    dp[i][j] = KnapsackMemoization.max(val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][w];
    }
}
