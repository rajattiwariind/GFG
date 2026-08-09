class Solution {
    public static int zigzagSequence(int[][] mat) {
        int n = mat.length;

        int[] dp = new int[n];

        // First row
        for (int j = 0; j < n; j++) {
            dp[j] = mat[0][j];
        }

        // Remaining rows
        for (int i = 1; i < n; i++) {

            int max1 = -1;
            int max2 = -1;
            int maxCol = -1;

            // Find largest and second largest dp values
            for (int j = 0; j < n; j++) {
                if (dp[j] > max1) {
                    max2 = max1;
                    max1 = dp[j];
                    maxCol = j;
                } else if (dp[j] > max2) {
                    max2 = dp[j];
                }
            }

            int[] newDp = new int[n];

            for (int j = 0; j < n; j++) {

                // Previous element cannot be from same column
                int bestPrevious;

                if (j == maxCol) {
                    bestPrevious = max2;
                } else {
                    bestPrevious = max1;
                }

                newDp[j] = mat[i][j] + bestPrevious;
            }

            dp = newDp;
        }

        // Maximum sum in last row
        int answer = 0;

        for (int j = 0; j < n; j++) {
            answer = Math.max(answer, dp[j]);
        }

        return answer;
    }
}
