package Knapsack;

public class countSubset {
    public static void main(String[] args) {
        int[] arr = new int[] {0,0,0,0,0,0,0,0,1};
        int sum = 1;
        System.out.println(countSubset(arr, arr.length, sum));
    }

    static int countSubset(int[] arr, int n, int sum) {
        int[][] dp = new int[n+1][sum+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if(i==0) dp[i][j] = 0;
                if(j==0) dp[i][j] = 1;
            }
        }

        // check if one subset is present or not, other one is depending
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum ;j++) {
                if(arr[i-1] <= j) {
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
            return dp[n][sum]%1000000007;
    }
}
