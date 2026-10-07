class Solution {
    int ans;

    int maxPathSum(Node root) {
        ans = Integer.MIN_VALUE;

        int maxRootToLeaf = dfs(root);

        // Fewer than two leaf nodes
        if (countLeaves(root) < 2) {
            return -1;
        }

        return ans;
    }

    int dfs(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        // Leaf node
        if (root.left == null && root.right == null) {
            return root.data;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        // Both children exist -> path between two leaves
        if (root.left != null && root.right != null) {
            ans = Math.max(ans, left + root.data + right);
            return root.data + Math.max(left, right);
        }

        // Only one child exists
        if (root.left != null) {
            return root.data + left;
        }

        return root.data + right;
    }

    int countLeaves(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return countLeaves(root.left) + countLeaves(root.right);
    }
}
