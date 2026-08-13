class Solution {
    public int[] maxDistance(int V, int src,
                             ArrayList<ArrayList<Integer>> edges) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[V];

        // Build graph
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);

            adj.get(u).add(new int[]{v, w});
            indegree[v]++;
        }

        // Topological sort
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] topo = new int[V];
        int idx = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            topo[idx++] = u;

            for (int[] edge : adj.get(u)) {
                int v = edge[0];

                if (--indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        // Initialize distances
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MIN_VALUE);

        dist[src] = 0;

        // Longest path DP
        for (int u : topo) {

            if (dist[u] == Integer.MIN_VALUE) {
                continue;
            }

            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                int w = edge[1];

                dist[v] = Math.max(dist[v], dist[u] + w);
            }
        }

        return dist;
    }
}
