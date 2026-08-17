import java.util.*;

class Solution {
    public int minThrows(int n, int[] lad, int[] sn) {
        int N = n * n;

        // jump[i] = destination after taking a snake or ladder
        int[] jump = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            jump[i] = i;
        }

        // Ladders
        for (int i = 0; i < lad.length; i += 2) {
            jump[lad[i]] = lad[i + 1];
        }

        // Snakes
        for (int i = 0; i < sn.length; i += 2) {
            jump[sn[i]] = sn[i + 1];
        }

        boolean[] visited = new boolean[N + 1];

        // {cell, number of throws}
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            int cell = curr[0];
            int throwsCount = curr[1];

            if (cell == N) {
                return throwsCount;
            }

            // Try dice values 1 to 6
            for (int dice = 1; dice <= 6; dice++) {
                int next = cell + dice;

                if (next > N) {
                    break;
                }

                // Take snake/ladder immediately
                next = jump[next];

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, throwsCount + 1});
                }
            }
        }

        return -1;
    }
}
