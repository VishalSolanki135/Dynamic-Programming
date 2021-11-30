package LongestCommonSubsequence;

public class Recursive {
    public static void main(String[] args) {
        String X = "abcdgh";
        String Y = "abedfhr";
        System.out.println(longestCommonSubsequence(X, Y, X.length(), Y.length()));
    }

    static int longestCommonSubsequence(String X, String Y, int n, int m) {
        // base condition
        if(n==0 || m==0) return 0;

        if(X.charAt(n-1) == Y.charAt(m-1)) return 1+longestCommonSubsequence(X, Y, n-1, m-1);
        else return Math.max(longestCommonSubsequence(X, Y, n, m-1), longestCommonSubsequence(X, Y, n-1, m));
    }
}
