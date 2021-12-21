package MatrixChainMultiplication;

import java.util.HashMap;

public class ScrambledStringDP {
    public static void main(String[] args) {
        String a = "abcgdhejiklhpyurtegabfdgrtyfgh";
        String b = "abchegytughfijklouhijyetarsgdf";
        System.out.println(solve(a, b));
    }

    static HashMap<String, Boolean> map = new HashMap<>();

    static boolean solve(String a, String b) {
        // base condition (last valid input)
        if(a.length()!=b.length()) return false;

        if(a.compareTo(b)==0) return true;

        if(a.length()<=1) return false;

        String key = a + " " + b;
        if(map.containsKey(key)) return map.get(key);

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
        map.put(key, flag);
        return map.get(key);
    }
}
