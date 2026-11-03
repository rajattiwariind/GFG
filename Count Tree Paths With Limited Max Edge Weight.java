class DSU {

    int[] parent, size;

    DSU(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    int union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return 0;

        int res = size[rootA] * size[rootB];

        if (size[rootA] < size[rootB]) {
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        } else {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }

        return res;
    }
}

class Solution {
    ArrayList<Integer> maximumWeight(int n, int edges[][], int queries[]) {

        DSU dsu = new DSU(n);

        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int total = 0;

        for (int[] edge : edges) {
            total += dsu.union(edge[0], edge[1]);
            map.put(edge[2], total);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int x : queries) {
            Map.Entry<Integer, Integer> entry = map.floorEntry(x);
            ans.add(entry == null ? 0 : entry.getValue());
        }

        return ans;
    }
}
