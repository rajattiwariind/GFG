class Solution {

    public int minEdgesReq(int n, int[][] edges) {

        if (edges.length < n - 1) {
            return -1;
        }

        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int extraEdges = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int pu = find(parent, u);
            int pv = find(parent, v);

            if (pu == pv) {
                // Redundant edge
                extraEdges++;
            } else {
                union(parent, rank, pu, pv);
            }
        }

        int components = 0;

        for (int i = 0; i < n; i++) {
            if (find(parent, i) == i) {
                components++;
            }
        }

        int required = components - 1;

        if (extraEdges >= required) {
            return required;
        }

        return -1;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }

        return parent[x];
    }

    private void union(int[] parent, int[] rank, int a, int b) {

        if (rank[a] < rank[b]) {
            parent[a] = b;
        } 
        else if (rank[a] > rank[b]) {
            parent[b] = a;
        } 
        else {
            parent[b] = a;
            rank[a]++;
        }
    }
}
