class Solution {
    int maxDiff(Node root) {
        int[] ans = {Integer.MIN_VALUE};
        dfs(root, root.data, ans);
        return ans[0];
    }

    void dfs(Node node, int maxAncestor, int[] ans) {
        if (node == null) {
            return;
        }

        // Only calculate difference for descendants
        if (node != null && node.data != maxAncestor) {
            ans[0] = Math.max(ans[0], maxAncestor - node.data);
        }

        maxAncestor = Math.max(maxAncestor, node.data);

        dfs(node.left, maxAncestor, ans);
        dfs(node.right, maxAncestor, ans);
    }
}
