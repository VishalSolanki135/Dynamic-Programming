package MatrixChainMultiplication;

import java.util.ArrayList;
import java.util.Arrays;

public class EggDropingDP {
    public static void main(String[] args) {
        int e = 2, f = 6;
        System.out.println(superEggDrop(e, f));
    }

    static int superEggDrop(int e, int f) {
        if(f==0 || f==1) return f;
        if(e==0 || e==1) return f;

        int[][] dp = new int[e+1][f+1];

        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }


        int min = Integer.MAX_VALUE;

        for (int k = 1; k <= f; k++) {
            int low, high;
            // if the egg breaks
            if(dp[e-1][k-1] != -1) {
                low = dp[e-1][k-1];
            } else {
                low = superEggDrop(e-1, k-1);
            }

            // if the egg does not break
            if(dp[e][f-k]!=-1) {
                high = dp[e][f-k];
            } else {
                high = superEggDrop(e, f-k);
            }

            int temp = 1 + Math.max(low, high);
            min = Math.min(min, temp);
        }
        return dp[e][f] = min;
    }
}
