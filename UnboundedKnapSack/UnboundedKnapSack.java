package UnboundedKnapSack;

public class UnboundedKnapSack {
    public static void main(String[] args) {
        int val[] = new int[] {10, 40, 50, 70};
        int wt[] = new int[] {1, 3, 4, 5};
        int w = 8;
        int n = val.length;
        System.out.println(knapsack(wt, val, w, n));
    }

    static int knapsack(int[] wt, int[] val, int w, int n) {
        int[][] dp = new int[n+1][w+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                if(i==0 || j==0) dp[i][j] = 0;
            }
        }

        // code based on choice
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if(wt[i-1]<=j) dp[i][j] = Math.max(dp[i-1][j], val[i-1]+dp[i][j-wt[i-1]]);
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][w];
    }
}
