package MatrixChainMultiplication;
public class Recursive {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 3};
        System.out.println(solve(arr, 1, arr.length-1));
    }

    static int solve(int[] arr, int i, int j) {
        if(i>=j) return 0;

        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j-1; k++) {
                int temp = solve(arr, i, k) + solve(arr, k+1, j) + (arr[i-1] * arr[k] * arr[j]);
            if(temp < min) min = temp;
        }
        return min;
    }
}
