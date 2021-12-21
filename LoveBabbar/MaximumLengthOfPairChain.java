package LoveBabbar;

import java.util.Arrays;

public class MaximumLengthOfPairChain {
    public static void main(String[] args) {
        int[][] pairs = {{1, 2}, {7, 8}, {4, 5}};
        System.out.println(findLongestChain(pairs));
    }

    static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b)->Double.compare(a[0], b[0]));
        int[] dp = new int[pairs.length];
        dp[0] = 1;

        for (int i = 1; i < pairs.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(pairs[j][1] < pairs[i][0] && dp[j]+1 > dp[i]) {
                    dp[i] = 1 + dp[j];
                }
            }
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
