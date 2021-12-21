package MatrixChainMultiplication;

import java.util.List;

public class printPP {
    public static void main(String[] args) {

    }

//    static List<List<String>> partition(String s, int i, int j) {
//
//    }

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
