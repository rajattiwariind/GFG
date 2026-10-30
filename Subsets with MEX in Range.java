class Solution {
    static final long MOD = 1000000007L;

    public int cntSubsets(int arr[], int l, int r) {
        int n = arr.length;

        int[] freq = new int[n + 1];

        for (int x : arr) {
            if (x <= n) {
                freq[x]++;
            }
        }

        // Precompute powers of 2
        long[] pow2 = new long[n + 1];
        pow2[0] = 1;

        for (int i = 1; i <= n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        long ans = 0;
        long required = 1;
        int prefixFreq = 0;

        for (int k = 0; k <= r; k++) {

            // Number k must be absent.
            int greaterCount = n - prefixFreq - freq[k];

            if (k >= l) {
                long ways = (required * pow2[greaterCount]) % MOD;
                ans = (ans + ways) % MOD;
            }

            // Every number from 0 to k must occur.
            if (freq[k] == 0) {
                break;
            }

            long choices = (pow2[freq[k]] - 1 + MOD) % MOD;

            required = (required * choices) % MOD;
            prefixFreq += freq[k];
        }

        return (int) ans;
    }
}
