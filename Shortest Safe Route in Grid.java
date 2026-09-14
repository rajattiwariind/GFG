import java.util.*;

class Solution {

    public int shortestPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // Mark unsafe cells
        boolean[][] unsafe = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] == 0) {
                    // Landmine itself
                    unsafe[i][j] = true;

                    // Cells adjacent to landmine
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dr[k];
                        int nj = j + dc[k];

                        if (ni >= 0 && ni < n &&
                            nj >= 0 && nj < m) {
                            unsafe[ni][nj] = true;
                        }
                    }
                }
            }
        }

        // {row, col, pathLength}
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];

        // Start from every safe cell in the first column.
        // Starting cell counts as length 1.
        for (int i = 0; i < n; i++) {
            if (!unsafe[i][0]) {
                q.offer(new int[]{i, 0, 1});
                visited[i][0] = true;
            }
        }

        // BFS
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];

            // Reached the last column
            if (c == m - 1) {
                return dist;
            }

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < m &&
                    !unsafe[nr][nc] &&
                    !visited[nr][nc]) {

                    visited[nr][nc] = true;

                    // One more cell in the path
                    q.offer(new int[]{nr, nc, dist + 1});
                }
            }
        }

        return -1;
    }
}
