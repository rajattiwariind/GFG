import java.util.*;

class Solution {
    
    public List<Integer> largestSquare(int[][] mat, int[][] queries, int k) {
        int n = mat.length;
        int m = mat[0].length;

        // 2D Prefix Sum
        int[][] prefix = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prefix[i + 1][j + 1] =
                    mat[i][j]
                    + prefix[i][j + 1]
                    + prefix[i + 1][j]
                    - prefix[i][j];
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int[] query : queries) {
            int r = query[0];
            int c = query[1];

            // Maximum possible radius
            int maxRadius = Math.min(
                Math.min(r, n - 1 - r),
                Math.min(c, m - 1 - c)
            );

            // Check 1 x 1 square
            if (mat[r][c] > k) {
                ans.add(-1);
                continue;
            }

            int low = 0;
            int high = maxRadius;
            int best = 0;

            // Binary search for largest valid square
            while (low <= high) {
                int mid = low + (high - low) / 2;

                int top = r - mid;
                int bottom = r + mid;
                int left = c - mid;
                int right = c + mid;

                int ones = getSum(prefix, top, left, bottom, right);

                if (ones <= k) {
                    best = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            // Radius 0 -> side 1
            // Radius 1 -> side 3
            // Radius 2 -> side 5
            ans.add(2 * best + 1);
        }

        return ans;
    }

    private int getSum(int[][] prefix, int r1, int c1, int r2, int c2) {
        return prefix[r2 + 1][c2 + 1]
             - prefix[r1][c2 + 1]
             - prefix[r2 + 1][c1]
             + prefix[r1][c1];
    }
}
