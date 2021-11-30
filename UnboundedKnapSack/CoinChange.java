package UnboundedKnapSack;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = new int[] {1, 2, 3};
        int sum = 5;

        System.out.println(change(coins, sum));
    }

    static int change(int[] arr, int sum) {
        int n = arr.length;
        int[][] dp = new int[n+1][sum+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if(i==0) dp[i][j] = 0;
                if(j==0) dp[i][j] = 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if(arr[i-1]<=j) dp[i][j] = dp[i-1][j] + dp[i][j - arr[i-1]];
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][sum];
    }
}
