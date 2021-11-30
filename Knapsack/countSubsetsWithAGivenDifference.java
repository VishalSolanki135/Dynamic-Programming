package Knapsack;

public class countSubsetsWithAGivenDifference {
    public static void main(String[] args) {
        int[] arr = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 1};
        int diff = 1;
        System.out.println(countSubsetWithDifference(arr,  diff));
    }

    static int countSubsetWithDifference(int[] arr, int diff) {
        int sum = 0;
        diff = Math.abs(diff);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        int target = (diff+sum)/2;

        if((diff+sum) % 2 == 1 || sum < diff) return 0;
        return countSubsetWithDifferenceUtil(arr, arr.length, target);
    }

    static int countSubsetWithDifferenceUtil(int[] arr, int n, int target) {


        int[][] dp = new int[n+1][target+1];


        for (int i = 0; i <= n ; i++) {
            for (int j = 0; j <= target; j++) {
                if(i==0) dp[i][j] = 0;
                if(j==0) dp[i][j] = 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if(arr[i-1]<=j) dp[i][j] = dp[i-1][j] + dp[i-1][j - arr[i-1]];
                else dp[i][j] = dp[i-1][j];
            }
        }

        return dp[n][target];
    }

}
