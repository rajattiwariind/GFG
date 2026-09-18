
class Solution {
    int minDiff = Integer.MAX_VALUE;
    int prev = -1;

    int absDiff(Node root) {
        inorder(root);
        return minDiff;
    }

    void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        if (prev != -1) {
            minDiff = Math.min(minDiff, root.data - prev);
        }

        prev = root.data;

        inorder(root.right);
    }
}

