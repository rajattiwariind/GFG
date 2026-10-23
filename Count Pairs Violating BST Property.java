class Solution {
    public int pairsViolatingBST(Node root) {
        java.util.List<Integer> values = new java.util.ArrayList<>();
        inorder(root, values);
        return countInversions(values);
    }

    private void inorder(Node root, java.util.List<Integer> values) {
        if (root == null) {
            return;
        }

        inorder(root.left, values);
        values.add(root.data);
        inorder(root.right, values);
    }

    private int countInversions(java.util.List<Integer> values) {
        int[] arr = values.stream().mapToInt(Integer::intValue).toArray();
        int[] temp = new int[arr.length];
        return mergeSort(arr, temp, 0, arr.length - 1);
    }

    private int mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int count = mergeSort(arr, temp, left, mid);
        count += mergeSort(arr, temp, mid + 1, right);

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += mid - i + 1;
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return count;
    }
}
