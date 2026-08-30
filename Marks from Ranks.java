class Solution {
    public List<Integer> getMarks(int[] l, int[] r, int[] rank) {
        int n = l.length;

        long[] prefix = new long[n];

        prefix[0] = (long) r[0] - l[0] + 1;

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + (long) r[i] - l[i] + 1;
        }

        List<Integer> ans = new ArrayList<>();

        for (int k : rank) {
            int idx = lowerBound(prefix, k);

            long before = (idx == 0) ? 0 : prefix[idx - 1];

            long offset = k - before - 1;

            ans.add((int) (l[idx] + offset));
        }

        return ans;
    }

    private int lowerBound(long[] arr, long target) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
