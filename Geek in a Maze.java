import java.util.*;

class Solution {
    static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int numberOfCells(int r, int c, int u, int d, char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        if (mat[r][c] == '#') {
            return 0;
        }

        int INF = Integer.MAX_VALUE;

        // Minimum number of upward moves required to reach each cell
        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
        }

        Deque<Node> dq = new ArrayDeque<>();

        dist[r][c] = 0;
        dq.offerFirst(new Node(r, c));

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!dq.isEmpty()) {
            Node cur = dq.pollFirst();

            int x = cur.r;
            int y = cur.c;
            int currUp = dist[x][y];

            for (int k = 0; k < 4; k++) {
                int nx = x + dr[k];
                int ny = y + dc[k];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (mat[nx][ny] == '#') {
                    continue;
                }

                // Moving up costs 1.
                // Down, left and right cost 0.
                int cost = (nx < x) ? 1 : 0;
                int newUp = currUp + cost;

                if (newUp < dist[nx][ny]) {
                    dist[nx][ny] = newUp;

                    if (cost == 0) {
                        dq.offerFirst(new Node(nx, ny));
                    } else {
                        dq.offerLast(new Node(nx, ny));
                    }
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (dist[i][j] == INF) {
                    continue;
                }

                int upMoves = dist[i][j];

                // i - r = downMoves - upMoves
                int downMoves = upMoves + (i - r);

                if (upMoves <= u && downMoves <= d) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
