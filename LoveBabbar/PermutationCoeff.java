package LoveBabbar;

public class PermutationCoeff {
    public static void main(String[] args) {
        System.out.println(permutationCoeff(10, 2));
        System.out.println(topDown(10, 2));
    }

    static int permutationCoeff(int n, int k) {
        if(k==0) return 1;
        if(k > n) return 0;

        return permutationCoeff(n-1, k) + k*permutationCoeff(n-1, k-1);
    }

    static int topDown(int n, int k) {
        int[][] dp = new int[n+1][k+1];

        for (int i = 0; i <=n ; i++) {
            for (int j = 0; j <=k ; j++) {
                if(j==0) dp[i][j] = 1;
            }
        }

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=k ; j++) {
                dp[i][j] = dp[i-1][j] + j * dp[i-1][j-1];
            }
        }
        return dp[n][k];
    }
}
