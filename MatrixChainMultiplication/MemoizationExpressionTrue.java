package MatrixChainMultiplication;

import java.util.HashMap;

public class MemoizationExpressionTrue {
    public static void main(String[] args) {
        String s = "T|T&F^T";
        System.out.println(parseBoolExpr(s, 0, s.length()-1, true));
    }

    static HashMap<String, Integer> map = new HashMap<>();

    static int parseBoolExpr(String s, int i, int j, boolean isTrue) {
        if(i>j) return 0;

        if(i==j) {
            if(isTrue) {
                if(s.charAt(i) == 'T') return 1;
                else return 0;
            } else {
                if(s.charAt(i) == 'F') return 1;
                else return 0;
            }
        }

        String temp = String.valueOf(i)+ " " + String.valueOf(j) + " " + String.valueOf(isTrue);

        if(map.containsKey(temp)) return map.get(temp);

        int ans = 0;

        for (int k = i; k <= j-1 ; k++) {
            int lT = parseBoolExpr(s, i, k-1, true);
            int lF = parseBoolExpr(s, i, k-1, false);
            int rT = parseBoolExpr(s, k+1, j, true);
            int rF = parseBoolExpr(s, k+1, j, false);

            if(s.charAt(k) == '&')  {
                if(isTrue) {
                    ans += lT*rT;
                } else {
                    ans += lT*rF + lF*rT + lF*rF;
                }
            } else if(s.charAt(k) == '|') {
                if(isTrue) {
                    ans += lT*rT + lT*rF + lF*rT;
                } else {
                    ans += lF*rF;
                }
            } else {
                if(isTrue) {
                    ans += lF*rT + rF*lT;
                } else {
                    ans += lT*rT + rF*lF;
                }
            }
        }
        map.put(temp, ans);
        return map.get(temp);
    }
}
