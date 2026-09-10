class Solution {
    public int pairCount(int x, int y) {
        if (y % x != 0) {
            return 0;
        }

        int n = y / x;
        int distinctPrimeFactors = 0;

        for (int p = 2; p * p <= n; p++) {
            if (n % p == 0) {
                distinctPrimeFactors++;

                while (n % p == 0) {
                    n /= p;
                }
            }
        }

        if (n > 1) {
            distinctPrimeFactors++;
        }

        return 1 << distinctPrimeFactors;
    }
}
