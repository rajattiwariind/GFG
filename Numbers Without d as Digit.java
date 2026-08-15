class Solution {
    public long countWithout(int n, int d) {
        if (n == 0) {
            return 0;
        }

        String s = String.valueOf(n);
        int len = s.length();
        long count = 0;

        // Numbers with fewer digits than n
        for (int digits = 1; digits < len; digits++) {
            if (d == 0) {
                count += 9 * power(9, digits - 1);
            } else {
                count += 8 * power(9, digits - 1);
            }
        }

        // Numbers with the same number of digits as n
        for (int i = 0; i < len; i++) {
            int current = s.charAt(i) - '0';
            int start = (i == 0) ? 1 : 0;

            for (int digit = start; digit < current; digit++) {
                if (digit == d) {
                    continue;
                }

                count += power(9, len - i - 1);
            }

            // Current digit is d, so n cannot be included
            if (current == d) {
                return count;
            }
        }

        // n itself does not contain d
        return count + 1;
    }

    private long power(int base, int exp) {
        long result = 1;

        while (exp-- > 0) {
            result *= base;
        }

        return result;
    }
}
