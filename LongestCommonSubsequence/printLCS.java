package LongestCommonSubsequence;

public class printLCS {
    public static void main(String[] args) {
        String X = "abac";
        String Y = "cab";
        System.out.println(printLCS(X, Y, X.length(), Y.length()));
    }

    static String printLCS(String X, String Y, int n, int m) {
        int[][] dp = new int[n+1][m+1];
        // initialization
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if(i==0 || j==0) dp[i][j] = 0;
            }
        }

        // choice based diagram
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(X.charAt(i-1) == Y.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        String s = "";

        int i = n;
        int j = m;
        while(i>0 && j>0) {
            if(X.charAt(i-1) == Y.charAt(j-1)) {
                s = Y.charAt(j-1) + s;
                i--;
                j--;
            } else {
                if(dp[i][j-1] > dp[i-1][j]) {
                    j--;
                } else {
                    i--;
                }
            }
        }
        return s;
    }
}
