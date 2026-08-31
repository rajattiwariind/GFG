class Solution {
    public int minCost(int n, int i, int d, int c) {

        int[] dp = new int[n + 1];

        // Cost to reach 0 characters
        dp[0] = 0;

        for (int x = 1; x <= n; x++) {

            // Option 1: Insert one character
            dp[x] = dp[x - 1] + i;

            // Option 2: Copy-paste from x / 2
            if (x % 2 == 0) {
                dp[x] = Math.min(
                    dp[x],
                    dp[x / 2] + c
                );
            }

            // Option 3: Copy-paste to x + 1, then delete one
            else {
                dp[x] = Math.min(
                    dp[x],
                    dp[(x + 1) / 2] + c + d
                );
            }
        }

        return dp[n];
    }
}
