package MatrixChainMultiplication;

public class EggDroppingTopDown {
    public static void main(String[] args) {
        int e = 10;
        int f = 10000;
        System.out.println(superEggDrop(e, f));
    }

    static int superEggDrop(int e, int f) {
        int dp[][] = new int[e + 1][f + 1];
        int min;

        // 1 move for 1 floor and 0 move for 0 floor
        for (int i = 1; i <= e; i++) {
            dp[i][1] = 1;
            dp[i][0] = 0;
        }

        // for 1 egg , floor trials are needed
        for (int j = 1; j <= f; j++)
            dp[1][j] = j;

        for (int i = 2; i <= e; i++) {
            for (int j = 2; j <= f; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <= j; x++) {
                    min = 1 + Math.max(
                            dp[i - 1][x - 1],
                            dp[i][j - x]);
                    if (min < dp[i][j])
                        dp[i][j] = min;
                }
            }
        }
        return dp[e][f];
    }
}
