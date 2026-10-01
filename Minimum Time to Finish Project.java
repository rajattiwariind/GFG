import java.util.*;

class Solution {
    public int minTime(int[] duration, int[][] dependencies) {
        int n = duration.length;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        // Build graph
        for (int[] edge : dependencies) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            indegree[v]++;
        }

        // finish[i] = earliest time module i can be completed
        long[] finish = new long[n];

        Queue<Integer> queue = new ArrayDeque<>();

        // Modules with no dependencies can start immediately
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                finish[i] = duration[i];
                queue.offer(i);
            }
        }

        int processed = 0;
        long answer = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            processed++;

            answer = Math.max(answer, finish[u]);

            for (int v : graph.get(u)) {

                // v can finish only after u finishes
                finish[v] = Math.max(
                    finish[v],
                    finish[u] + duration[v]
                );

                indegree[v]--;

                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        // If some modules were not processed, there is a cycle
        if (processed != n) {
            return -1;
        }

        return (int) answer;
    }
}
