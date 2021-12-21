package LoveBabbar;

import java.util.HashMap;

public class LongestSubseqenceWithGivenDifference {
    public static void main(String[] args) {
        int[] arr = {1,2, 3, 4};

        System.out.println(longestSubsequence1(arr, 1));
    }

    // O(n^2) method
    static int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        int[] dp = new int[n];

        int count = 0;
        dp[0] = 1;

        for(int i = 1; i < n; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if(arr[i]-arr[j] == difference){
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                }
            }
        }
        int max = 0;

        for (int i = 0; i < n; i++) {
            if(max<dp[i]) max = dp[i];
        }
        return max;
    }

    // O(n) method using hashmap

    static int longestSubsequence1(int[] arr, int difference) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : arr) {
            int count = map.getOrDefault(n, 0);
            map.put(n + difference , count+1);
        }

        int max = 1;
        for (int val : map.values()) {
            max = Math.max(max, val);
        }
        return max;
    }
}
