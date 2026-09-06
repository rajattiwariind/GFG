class Solution {
    public long pairAndSum(int[] arr) {
        long ans = 0;
        int n = arr.length;

        // arr[i] <= 1e8, so 31 bits are sufficient
        for (int bit = 0; bit < 31; bit++) {
            long count = 0;

            // Count numbers having this bit set
            for (int num : arr) {
                if ((num & (1 << bit)) != 0) {
                    count++;
                }
            }

            // Number of pairs having this bit set in both elements
            long pairs = count * (count - 1) / 2;

            // Add contribution of this bit
            ans += pairs * (1L << bit);
        }

        return ans;
    }
}
