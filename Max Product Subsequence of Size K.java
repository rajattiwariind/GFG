class Solution {
    public long maxProduct(int[] arr, int k) {
        long[] max = new long[k + 1];
        long[] min = new long[k + 1];

        boolean[] possible = new boolean[k + 1];
        possible[0] = true;
        max[0] = min[0] = 1;

        for (int x : arr) {
            for (int j = k; j >= 1; j--) {
                if (!possible[j - 1]) continue;

                long a = max[j - 1] * x;
                long b = min[j - 1] * x;

                long newMax = Math.max(a, b);
                long newMin = Math.min(a, b);

                if (!possible[j]) {
                    max[j] = newMax;
                    min[j] = newMin;
                    possible[j] = true;
                } else {
                    max[j] = Math.max(max[j], newMax);
                    min[j] = Math.min(min[j], newMin);
                }
            }
        }

        return max[k];
    }
}
