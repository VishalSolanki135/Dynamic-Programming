package Knapsack;

import java.util.Arrays;

public class KnapsackMemoization {
    public static void main(String[] args) {
        int val[] = new int[] {60, 100, 120};
        int wt[] = new int[] {10, 20, 30};
        int w = 50;
        int n = val.length;
        System.out.println(knapsack(wt, val, w, n));
    }

    static int knapsack(int[] wt, int[] val, int w, int n) {
        int[][] dp = new int[n+2][w+2];
        for (int[] r: dp) {
            Arrays.fill(r, -1);
        }
        //base condition(i.e. check the minimum valid input)
        if(w==0 || n==0) return 0;

        if(dp[n][w]!=-1) return dp[n][w];
        // choice diagram code
        if(wt[n-1] > w)  dp[n][w] = knapsack(wt, val, w, n-1);
        else dp[n][w] =  max(val[n-1] + knapsack(wt, val, w-wt[n-1], n-1), knapsack(wt, val, w, n-1));

        return dp[n][w];
    }

    static int max(int a, int b) {
        return (a>b) ? a : b;
    }
}
