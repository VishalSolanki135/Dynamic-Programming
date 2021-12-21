package MatrixChainMultiplication;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "geek";
        System.out.println(partition(s, 0, s.length()-1));
    }

    static int partition(String s, int i, int j) {
        if(i>=j) return 0; // out of bounds return 0

        if(isPalindrome(s, i, j)) return 0;// if already a palindrome return 0

        int min = Integer.MAX_VALUE;

        for (int k = i; k <= j-1; k++) {
            int temp = partition(s, i, k) + partition(s, k+1, j) + 1;
            if(temp < min) min = temp;
        }
        return min;
    }

    static boolean isPalindrome(String s, int i, int j) {
        while(i < j)
        {
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
