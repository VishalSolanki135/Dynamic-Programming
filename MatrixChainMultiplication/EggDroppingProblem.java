package MatrixChainMultiplication;

public class EggDroppingProblem {
    public static void main(String[] args) {
        int e = 2, f = 6;
        System.out.println(superEggDrop(e, f));
    }

    static int superEggDrop(int e, int f) {
        if(f==0 || f==1) return f; // we have to find the answer for worst case
        if(e==0 || e==1) return f;

        int min = Integer.MAX_VALUE;

        for (int k = 1; k <f ; k++) {
            int temp = 1 + Math.max(superEggDrop(e-1, k-1), superEggDrop(e, f-k));
            min = Math.min(min, temp);
        }
        return min;
    }
}
