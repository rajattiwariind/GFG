import java.util.ArrayList;

class Solution {

    // Function to calculate the greatest common divisor using Euclidean algorithm
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Segment Tree class
    static class SegmentTree {
        private int[] tree;
        private int n;

        public SegmentTree(int[] arr) {
            this.n = arr.length;
            this.tree = new int[4 * n];
            build(arr, 0, 0, n - 1);
        }

        // Build the segment tree
        private void build(int[] arr, int node, int start, int end) {
            if (start == end) {
                tree[node] = arr[start];
                return;
            }
            int mid = start + (end - start) / 2;
            build(arr, 2 * node + 1, start, mid);
            build(arr, 2 * node + 2, mid + 1, end);
            tree[node] = gcd(tree[2 * node + 1], tree[2 * node + 2]);
        }

        // Point update: update arr[index] to value
        public void update(int node, int start, int end, int index, int value) {
            if (start == end) {
                tree[node] = value;
                return;
            }
            int mid = start + (end - start) / 2;
            if (index >= start && index <= mid) {
                update(2 * node + 1, start, mid, index, value);
            } else {
                update(2 * node + 2, mid + 1, end, index, value);
            }
            tree[node] = gcd(tree[2 * node + 1], tree[2 * node + 2]);
        }

        // Range query: get GCD in range [l, r]
        public int query(int node, int start, int end, int l, int r) {
            if (r < start || end < l) {
                return 0; // 0 is the identity element for GCD
            }
            if (l <= start && end <= r) {
                return tree[node];
            }
            int mid = start + (end - start) / 2;
            int p1 = query(2 * node + 1, start, mid, l, r);
            int p2 = query(2 * node + 2, mid + 1, end, l, r);
            return gcd(p1, p2);
        }
    }

    // Method matching GFG's driver code expected signature
    public ArrayList<Integer> processQueries(int[] arr, int[][] queries) {
        SegmentTree segTree = new SegmentTree(arr);
        ArrayList<Integer> result = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0];
            if (type == 0) {
                int l = q[1];
                int r = q[2];
                result.add(segTree.query(0, 0, arr.length - 1, l, r));
            } else if (type == 1) {
                int index = q[1];
                int value = q[2];
                segTree.update(0, 0, arr.length - 1, index, value);
            }
        }

        return result;
    }
}
