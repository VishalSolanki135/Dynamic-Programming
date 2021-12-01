package LongestCommonSubsequence;

public class ShortestCommonSuperSequence {
    public static void main(String[] args) {
        String X = "abac";
        String Y = "cab";
        System.out.println(shortestCommonSupersequence(X, Y));
    }

    static String shortestCommonSupersequence(String X, String Y) {
        int n = X.length();
        int m = Y.length();

        return helper(X, Y, n, m);
    }

    static String helper(String X, String Y, int n, int m) {
        int[][] dp = new int[n+1][m+1];
        // initialization
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if(i==0 || j==0) dp[i][j] = 0;
            }
        }

        // choice based diagram
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                if(X.charAt(i-1)==Y.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }

        // getting the longest common subsequence
        String s = "";
        int i = n;
        int j = m;

        while(i > 0 && j > 0) {
            if(X.charAt(i-1) == Y.charAt(j-1)) {
                s = X.charAt(i-1) + s;
                i--;
                j--;
            } else {
                if(dp[i-1][j]>dp[i][j-1]) {
                    s = X.charAt(i-1) + s;
                    i--;
                } else {
                    s = Y.charAt(j-1) + s;
                    j--;
                }
            }
        }

        while(i>0) {
            s = X.charAt(i-1) + s;
            i--;
        }
        while(j>0) {
            s = Y.charAt(j-1) + s;
            j--;
        }

        return s;
    }
}
