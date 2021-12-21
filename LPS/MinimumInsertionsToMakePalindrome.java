package LPS;

public class MinimumInsertionsToMakePalindrome {
    public static void main(String[] args) {
        String X = "mbadm";
        System.out.println(lps(X));
    }

    static int lps(String X) {
        String Y = reverse("", X);
        int n = X.length();
        int m = Y.length();

        return helper(X, Y, n, m);
    }

    static int helper(String X, String Y, int n, int m) {
        int[][] dp = new int[n+1][m+1];
        //initialization
        for (int i = 0; i <=n ; i++) {
            for (int j = 0; j <=m ; j++) {
                if(i==0 || j==0) dp[i][j] = 0;
            }
        }

        // choice based code
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                if(X.charAt(i-1) == Y.charAt(j-1)) {
                    dp[i][j] = 1+dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return n-dp[n][m];
    }

    static String reverse(String p, String s) {
        if(s.isEmpty()) {
            return p;
        }
        char ch = s.charAt(s.length()-1);
        return reverse(p+ch, s.substring(0, s.length()-1));
    }
}
