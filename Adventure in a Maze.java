import java.util.*;

class Solution {
    static final int MOD = 1000000007;

    public ArrayList<Integer> findWays(int[][] matrix) {
        int n = matrix.length;

        long[][] ways = new long[n][n];
        long[][] maxSum = new long[n][n];

        ways[0][0] = 1;
        maxSum[0][0] = matrix[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0)
                    continue;

                long count = 0;
                long best = -1;

                // From TOP
                if (i > 0 &&
                    (matrix[i - 1][j] == 2 || matrix[i - 1][j] == 3) &&
                    ways[i - 1][j] > 0) {

                    count = ways[i - 1][j];

                    best = maxSum[i - 1][j] + matrix[i][j];
                }

                // From LEFT
                if (j > 0 &&
                    (matrix[i][j - 1] == 1 || matrix[i][j - 1] == 3) &&
                    ways[i][j - 1] > 0) {

                    count = (count + ways[i][j - 1]) % MOD;

                    long candidate =
                        maxSum[i][j - 1] + matrix[i][j];

                    best = Math.max(best, candidate);
                }

                ways[i][j] = count;

                if (count == 0) {
                    maxSum[i][j] = 0;
                } else {
                    maxSum[i][j] = best;
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        ans.add((int) ways[n - 1][n - 1]);
        ans.add((int) maxSum[n - 1][n - 1]);

        return ans;
    }
}
