package LoveBabbar;

public class LongestSumIncreasingSub {
    public static void main(String[] args) {
        int[] arr = {1, 101, 2, 3, 100, 4, 5};
        System.out.println(longestSum(arr, arr.length));
    }

    static int longestSum(int[] arr, int n) {
        int[] dp = new int[n];
        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {
            dp[i] = arr[i];

            for (int j = 0; j < i; j++) {
                if(arr[i]>arr[j] && (dp[j]+arr[i] > dp[i])) {
                    dp[i] = dp[j] + arr[i];
                }
            }
        }

        int max = 0;
        for(int i = 0; i<n; i++) {
            if(max < dp[i]) max = dp[i];
        }
        return max;
    }
}
