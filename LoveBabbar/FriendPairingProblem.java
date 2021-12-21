package LoveBabbar;

public class FriendPairingProblem {
    public static void main(String[] args) {
        System.out.println(pair(4));
    }

    static int pair(int n) {
        int[] dp = new int[n+1];

        // code based on choice
        for (int i = 0; i <=n ; i++) {
            if(i<=2) {
                dp[i] = i;
            } else {
                dp[i] = dp[i-1] + dp[i-2]*(i-1);
            }
        }
        return dp[n];
    }
}
