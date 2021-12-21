package LoveBabbar;

public class MaxSubSequenceSumSuchThatNoThreeAreConse {
    public static void main(String[] args) {
        int[] arr = {100, 1000, 100, 1000, 1};
        System.out.println(maxLength(arr, arr.length));
    }

    static int maxLength(int[] arr, int n) {
        int[] dp = new int[n];

        // base cases
        if(n>=1) dp[0] = arr[0];
        if(n>=2) dp[1] = arr[0] + arr[1];
        if(n>=3) dp[2] = Math.max(dp[1], Math.max(arr[1] + arr[2], arr[0] + arr[2]));

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(arr[i-2]+arr[i], dp[i-3]+arr[i]+arr[i-1]));
        }
        return dp[n-1];
    }
}
