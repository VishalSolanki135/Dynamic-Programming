package LoveBabbar;

import java.util.Arrays;

public class GoldMineProblemLeetcode {
    static boolean[][] visited;
    public static void main(String[] args) {
        int[][] arr = {{0, 6, 0},
                {5, 8, 7},
                {0, 9, 0}};
        System.out.println(maxGold(arr, 3, 3 ));
    }

    static int maxGold(int[][] arr, int n, int m) {
        visited = new boolean[n][m];
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] != 0) ans = Math.max(ans, find(arr, i, j));
            }
        }
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }

    static int find(int[][] arr, int i, int j) {
        if(i < 0 || j<0 || i>=arr.length || j >= arr[0].length || visited[i][j] || arr[i][j] == 0) return 0;

        // marked current path as true is visited array TEMPORARILY
        visited[i][j] = true;
        int temp = Integer.MIN_VALUE;
        temp = Math.max(temp, find(arr, i+1, j));
        temp = Math.max(temp, find(arr, i-1, j));
        temp = Math.max(temp, find(arr, i, j+1));
        temp = Math.max(temp, find(arr, i, j-1));
        visited[i][j] = false;

        return arr[i][j] + temp; // maximum for particular index
    }
}
