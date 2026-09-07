class Solution {
    public int minCount(int[] arr) {
        int n = arr.length;

        int[][][] dp = new int[n + 1][n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return solve(arr, 0, -1, -1, dp);
    }

    private int solve(int[] arr, int pos, int inc, int dec, int[][][] dp) {
        int n = arr.length;

        if (pos == n) {
            return 0;
        }

        if (dp[pos][inc + 1][dec + 1] != -1) {
            return dp[pos][inc + 1][dec + 1];
        }

        // Don't use this element
        int ans = 1 + solve(arr, pos + 1, inc, dec, dp);

        // Put in increasing subsequence
        if (inc == -1 || arr[pos] > arr[inc]) {
            ans = Math.min(ans,
                    solve(arr, pos + 1, pos, dec, dp));
        }

        // Put in decreasing subsequence
        if (dec == -1 || arr[pos] < arr[dec]) {
            ans = Math.min(ans,
                    solve(arr, pos + 1, inc, pos, dp));
        }

        return dp[pos][inc + 1][dec + 1] = ans;
    }
}
