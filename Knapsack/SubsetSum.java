package Knapsack;

import java.util.Arrays;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 5};
        int sum = 4;
        int n = arr.length;
//        System.out.println(isSubset(arr, n, sum));
//        System.out.println(isSubsetMemo(arr, n, sum));
        System.out.println(topDownSubset(arr, n, sum));
    }

    // using recursion
    static boolean isSubset(int[] arr, int n, int sum) {
        // base condition
        if(sum==0) return true;
        if(n==0) return false;

        if(arr[n-1] > sum) return isSubset(arr, n-1, sum);

        return isSubset(arr, n-1, sum-arr[n-1]) || isSubset(arr, n-1, sum);
    }

    // using memoization
    static int isSubsetMemo(int[] arr, int n, int sum){
        int[][] dp = new int[n+1][sum+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = -1;
            }
        }

        if(sum == 0) return 1;

        if(n<=0) return 0;

        if(dp[n-1][sum]!=-1) return dp[n-1][sum] = isSubsetMemo(arr, n-1, sum);

        if(arr[n-1]>sum) return dp[n-1][sum] = isSubsetMemo(arr, n-1, sum);
        else {
            if(isSubsetMemo(arr, n-1, sum)!=0 || isSubsetMemo(arr, n-1, sum - arr[n-1]) !=0) return dp[n-1][sum]=1;
            else return dp[n-1][sum] = 0;
        }
    }

    // using top down approach

    static boolean topDownSubset(int[] arr, int n, int sum){
        boolean[][] dp = new boolean[n+1][sum+1];
        // initialization
        for(int i = 0; i <= n; i++) {
            for (int j = 0; j <=sum ; j++) {
                if(i==0) dp[i][j] = false;
                if(j==0) dp[i][j] = true;
            }
        }

        // choice based code
        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j - arr[i-1]] || dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
