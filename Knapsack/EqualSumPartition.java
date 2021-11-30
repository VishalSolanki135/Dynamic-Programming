package Knapsack;

public class EqualSumPartition {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 5};
        System.out.println(canPartition(arr));
    }

    static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        System.out.println(sum/2);
        if(sum%2!=0) return false;
        else return subsetSum(nums, nums.length, sum/2);
    }

    static boolean subsetSum(int[] arr, int n, int sum) {
        boolean[][] dp = new boolean[n+1][sum+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if(i==0) dp[i][j] = false;
                if(j==0) dp[i][j] = true;
            }
        }

        // check if one subset is present or not, other one is depending
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum ;j++) {
                if(arr[i-1] <= j) {
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
