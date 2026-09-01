class Solution {
    static final long MOD = 1000000007L;

    public int palindromicStrings(int n, int k) {
        long ans = 0;
        long perm = 1; // P(k, 0)

        for (int len = 1; len <= n; len++) {
            int half = len / 2;

            // Update P(k, half) when half increases
            if (len > 1 && len % 2 == 0) {
                perm = (perm * (k - half + 1)) % MOD;
            }

            long count;

            if (len % 2 == 0) {
                // Even length: 2 * half
                count = perm;
            } else {
                // Odd length: 2 * half + 1
                // Middle character must be unused in the first half
                count = (perm * (k - half)) % MOD;
            }

            ans = (ans + count) % MOD;
        }

        return (int) ans;
    }
}
