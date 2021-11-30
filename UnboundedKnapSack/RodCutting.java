package UnboundedKnapSack;

public class RodCutting {
    public static void main(String[] args) {
        int[] length = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        int[] price = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
        int max_len = 8;
        System.out.println(maximumPrice(length, price, length.length, max_len));

    }

    // maximum price
    static int maximumPrice(int[] length, int[] price, int n, int max_len) {
        int[][] dp = new int[n+1][max_len+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= max_len; j++) {
                if(i==0 || j==0) dp[i][j] = 0;
            }
        }

        // code based on choice(multiple occurrences)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= max_len; j++) {
                if(length[i-1]<=j) dp[i][j] = Math.max(dp[i-1][j], price[i-1]+dp[i][j-length[i-1]]);
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][max_len];
    }
}
