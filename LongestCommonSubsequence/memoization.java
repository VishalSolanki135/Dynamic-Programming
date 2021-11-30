package LongestCommonSubsequence;

import java.util.Arrays;

public class memoization {
    public static void main(String[] args) {
        String X = "abc";
        String Y = "defa";
        System.out.println(longestCommonSubsequence(X, Y, X.length(), Y.length()));
    }

    static int longestCommonSubsequence(String X, String Y, int n, int m) {
        int[][] dp = new int[n+1][m+1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        if(n==0 || m==0) return 0;
        if(dp[n][m]!=-1) return dp[n][m];

        // choice based diagram
        if(X.charAt(n-1)==Y.charAt(m-1)) dp[n][m] = 1+longestCommonSubsequence(X, Y, n-1, m-1);
        else dp[n][m] = Math.max(longestCommonSubsequence(X, Y, n-1, m), longestCommonSubsequence(X, Y, n, m-1));
        return dp[n][m];
    }
}
