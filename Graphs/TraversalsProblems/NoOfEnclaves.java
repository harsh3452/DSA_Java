import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int numEnclaves(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] visited = new int[r][c];
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0 || j == 0 || i == r - 1 || j == c - 1) {
                    if (grid[i][j] == 1) {
                        q.offer(new int[]{i, j});
                        visited[i][j] = 1;
                    }
                }
            }
        }

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];

            for (int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if (nrow >= 0 && nrow < r && ncol >= 0 && ncol < c
                        && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    q.offer(new int[]{nrow, ncol});
                    visited[nrow][ncol] = 1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}