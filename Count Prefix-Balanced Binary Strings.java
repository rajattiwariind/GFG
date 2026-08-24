class Solution {
    static final long MOD = 1_000_000_007L;

    static long power(long a, long b) {
        long result = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                result = result * a % MOD;
            }

            a = a * a % MOD;
            b >>= 1;
        }

        return result;
    }

    public long prefixStrings(int n) {
        int size = 2 * n;

        long[] fact = new long[size + 1];
        fact[0] = 1;

        for (int i = 1; i <= size; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        // C(2n, n)
        long ans = fact[2 * n];

        // Divide by n! twice
        ans = ans * power(fact[n], MOD - 2) % MOD;
        ans = ans * power(fact[n], MOD - 2) % MOD;

        // Divide by (n + 1)
        ans = ans * power(n + 1, MOD - 2) % MOD;

        return ans;
    }
}
