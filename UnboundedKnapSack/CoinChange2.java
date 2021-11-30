package UnboundedKnapSack;

public class CoinChange2 {
    public static void main(String[] args) {
        int[] arr = new int[]{2};
        int amount = 3;
        System.out.println(change(arr, amount));
    }

    static int change(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        if(coins.length==1 && coins[0]/amount!=0) return -1;

        // initialization
        for (int i = 0; i <=n ; i++) {
            for (int j = 0; j <=amount ; j++) {
                if(i==0) dp[i][j] = Integer.MAX_VALUE-1;
                if(j==0) dp[i][j] = 0;
            }
        }

        // initialization of first row when we have only one coin
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=amount ; j++) {
                if(j%coins[0] == 0) dp[i][j] = j / coins[0];
                else dp[i][j] = Integer.MAX_VALUE-1;
            }
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <=amount ; j++) {
                if(coins[i-1]<=j) dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j - coins[i-1]]);
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][amount];
    }
}
