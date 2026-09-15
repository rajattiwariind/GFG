class Solution {
    
    public int getCount(Node root, int k) {
        if (root == null) {
            return 0;
        }

        // count[i] = number of leaf nodes at level i
        int[] count = new int[k + 1];

        collectLeaves(root, 1, k, count);

        int ans = 0;

        // Pick leaves with the lowest cost first
        for (int level = 1; level <= k; level++) {
            int leaves = count[level];

            int take = Math.min(leaves, k / level);

            ans += take;
            k -= take * level;

            if (k == 0) {
                break;
            }
        }

        return ans;
    }

    private void collectLeaves(Node root, int level, int k, int[] count) {
        if (root == null || level > k) {
            return;
        }

        // Leaf node
        if (root.left == null && root.right == null) {
            count[level]++;
            return;
        }

        collectLeaves(root.left, level + 1, k, count);
        collectLeaves(root.right, level + 1, k, count);
    }
}
