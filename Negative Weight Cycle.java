class Solution {
    public boolean isNegativeWeightCycle(int V, int[][] edges) {
        long[] dist = new long[V];

        // dist[] = 0 for all vertices.
        // This effectively adds a super-source connected to every vertex
        // with an edge of weight 0, so cycles in any component are detected.

        for (int i = 0; i < V; i++) {
            boolean updated = false;

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    updated = true;

                    // Relaxation on the V-th iteration means
                    // a negative-weight cycle exists.
                    if (i == V - 1) {
                        return true;
                    }
                }
            }

            // No changes means no negative cycle.
            if (!updated) {
                break;
            }
        }

        return false;
    }
}
