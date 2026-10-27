class Solution {
    public int getMaxWeight(String s) {
                // code here
                int n = s.length();
                if (n == 0) return 0;

                int tg = 0, ntg = 1; // dp[0][tg], dp[0][ntg]

                int prev2_tg = 0, prev2_ntg = 0;

                for (int i = 1; i < n; i++) {
                    int curr_tg, curr_ntg;

                    if (s.charAt(i) == s.charAt(i - 1)) {
                        curr_tg = 3 + (i > 1 ? Math.max(prev2_tg, prev2_ntg) : 0);
                        curr_ntg = 1 + Math.max(tg, ntg);
                    } else {
                        curr_tg = Math.max(tg, ntg);
                        curr_ntg = 4 + (i > 1 ? Math.max(prev2_tg, prev2_ntg) : 0);
                    }

                    // Shift i-1 states to i-2 states
                    prev2_tg = tg;
                    prev2_ntg = ntg;

                    // Update i-1 states to current states
                    tg = curr_tg;
                    ntg = curr_ntg;
                }

                return Math.max(tg, ntg);
    }
}
