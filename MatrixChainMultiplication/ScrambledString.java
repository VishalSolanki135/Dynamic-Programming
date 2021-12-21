package MatrixChainMultiplication;

public class ScrambledString {
    public static void main(String[] args) {
        String a = "coder";
        String b = "ocerd";
        System.out.println(solve(a, b));
    }

    static boolean solve(String a, String b) {
        // base condition (last valid input)
        if(a.length()!=b.length()) return false;

        if(a.compareTo(b)==0) return true;

        if(a.length()<=1) return false;

        boolean flag = false;
        int n = a.length();

        for(int i = 1; i<= n-1; i++) {
            // check condition for swapping or non-swapping strings
            if((solve(a.substring(0, i), b.substring(n-i, n)) && solve(a.substring(i, n), b.substring(0, n-i))) ||
                    (solve(a.substring(0, i), b.substring(0, i)) && solve(a.substring(i, n), b.substring(i, n)))) {
                flag = true;
                break;
            }
        }
        return flag;
    }

}
