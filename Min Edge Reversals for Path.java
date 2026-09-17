import java.util.*;

class Solution {
    
    // Helper class to store destination vertex and edge weight
    static class Edge {
        int v, weight;
        Edge(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }

    public int minimumEdgeReversal(int[][] edges, int n, int src, int dst) {
        // Build adjacency list
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(new Edge(v, 0)); // Original edge: cost 0
            adj.get(v).add(new Edge(u, 1)); // Reversed edge: cost 1
        }

        // Distance array to store minimum reversals to reach each node
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Deque for 0-1 BFS
        Deque<Integer> dq = new LinkedList<>();
        dq.addFirst(src);

        while (!dq.isEmpty()) {
            int u = dq.pollFirst();

            // If we reached the destination, return the minimum distance
            if (u == dst) {
                return dist[dst];
            }

            for (Edge neighbor : adj.get(u)) {
                int v = neighbor.v;
                int weight = neighbor.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    
                    // 0-weight edges go to the front, 1-weight edges go to the back
                    if (weight == 0) {
                        dq.addFirst(v);
                    } else {
                        dq.addLast(v);
                    }
                }
            }
        }

        // If destination is unreachable
        return -1;
    }
}
