package LoveBabbar;

import java.util.Arrays;

public class BinomialCoef {
    public static void main(String[] args) {
        System.out.println(binomialCoeff(2, 4));
        System.out.println(binomialCoeffMemo(5, 2));
        System.out.println(binomialCoeffMemo(5, 2 ));
    }

    // recursion
    static int binomialCoeff(int n, int r) {
        if(r>n) return 0;
        if(r == 0 || n == r) return 1;

        return binomialCoeff(n-1, r-1) + binomialCoeff(n-1, r);
    }

    // memorization
    static int binomialCoeffMemo(int n, int r) {
        int[][] dp = new int[n+1][r+1];
        if(r > n) return 0;
        if(r==0 || n == r) return 1;

        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        if(dp[n][r]!=-1) return dp[n][r];

        return dp[n][r] = binomialCoeffMemo(n-1, r-1) + binomialCoeffMemo(n-1, r);
    }

    // top down approach
    static int binomialCoeffTopDown(int n, int r) {
        int[][] dp = new int[n+1][r+1];

        // initialization
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= r; j++) {
                if(j == 0 || j==i) dp[i][j] = 1;
            }
        }

        // dp code
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=r ; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        return dp[n][r];
    }
}
