class Solution {

    private Node lca(Node root, int p, int q) {
        if (root == null || root.data == p || root.data == q)
            return root;

        Node left = lca(root.left, p, q);
        Node right = lca(root.right, p, q);

        if (left != null && right != null)
            return root;

        return left != null ? left : right;
    }

    // Returns turns from root to target.
    // dir: 0 = none, 1 = left, 2 = right
    private int getTurns(Node root, int target, int dir) {
        if (root == null)
            return -1;

        if (root.data == target)
            return 0;

        int left = getTurns(root.left, target, 1);

        if (left != -1) {
            return left + ((dir == 2) ? 1 : 0);
        }

        int right = getTurns(root.right, target, 2);

        if (right != -1) {
            return right + ((dir == 1) ? 1 : 0);
        }

        return -1;
    }

    public int numberOfTurns(Node root, int first, int second) {

        Node ancestor = lca(root, first, second);

        if (ancestor == null)
            return -1;

        int firstTurns = getTurns(ancestor, first, 0);
        int secondTurns = getTurns(ancestor, second, 0);

        // If LCA is one of the two nodes, don't add the LCA turn.
        if (ancestor.data == first || ancestor.data == second) {
            int ans = firstTurns + secondTurns;
            return ans == 0 ? -1 : ans;
        }

        // LCA is between first and second.
        int ans = firstTurns + secondTurns + 1;

        return ans;
    }
}
