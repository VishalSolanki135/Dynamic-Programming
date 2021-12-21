package LoveBabbar;

public class LongestIncreasingSubs {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 2, 3};
        System.out.println(LIS(arr, arr.length));
        System.out.println(dp(arr, arr.length));
    }

    static int max;

    // recursive approach
    static int LIS(int[] arr, int n) {
        max = 1;

        lis_util(arr, n);

        return max;
    }

    static int lis_util(int[] arr, int n){
        if(n==1) return 1;

        int ans, max_till_now = 1;

        for (int i = 1; i < n; i++) {
            ans = lis_util(arr, i);

            if(arr[i-1]<arr[n-1] && (ans+1) > max_till_now) {
                max_till_now = ans+1;
            }
        }
        if(max < max_till_now) max = max_till_now;
        return max_till_now;
    }


    // dynamic approach

    static int dp(int[] arr, int n) {
        int[] dp = new int[n];

        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[j]<arr[i] && (dp[j]+1) > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            if(max < dp[i]) max = dp[i];
        }
        return max;
    }
}
