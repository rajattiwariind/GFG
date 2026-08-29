class Solution {
    static final long MOD = 1_000_000_007L;

    public int countSubsequences(String s, int n) {
        long[] dp = new long[n];

        for (char ch : s.toCharArray()) {
            int d = ch - '0';

            // New subsequences formed using this digit.
            long[] add = new long[n];

            // The digit itself.
            add[d % n] = 1;

            // Append this digit to every previously formed subsequence.
            for (int r = 0; r < n; r++) {
                if (dp[r] != 0) {
                    int nr = (r * 10 + d) % n;
                    add[nr] = (add[nr] + dp[r]) % MOD;
                }
            }

            // Add the newly formed subsequences to dp.
            for (int r = 0; r < n; r++) {
                dp[r] = (dp[r] + add[r]) % MOD;
            }
        }

        return (int) dp[0];
    }
}
