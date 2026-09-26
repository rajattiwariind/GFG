import java.util.Arrays;

class Solution {
    public int minimumCost(int x, int s, int m, int l, int cs, int cm, int cl) {
        int[] dp = new int[x + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i <= x; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }

            // Try buying a Small pizza
            int nextS = Math.min(x, i + s);
            dp[nextS] = Math.min(dp[nextS], dp[i] + cs);

            // Try buying a Medium pizza
            int nextM = Math.min(x, i + m);
            dp[nextM] = Math.min(dp[nextM], dp[i] + cm);

            // Try buying a Large pizza
            int nextL = Math.min(x, i + l);
            dp[nextL] = Math.min(dp[nextL], dp[i] + cl);
        }

        return dp[x];
    }
}
