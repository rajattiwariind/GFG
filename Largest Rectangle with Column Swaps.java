import java.util.*;

class Solution {
    public int maxArea(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[] height = new int[m];
        int ans = 0;

        for (int i = 0; i < n; i++) {

            // Calculate consecutive 1s in each column
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }

            // Copy before sorting
            int[] temp = height.clone();
            Arrays.sort(temp);

            // Largest heights are at the end
            for (int j = m - 1; j >= 0; j--) {
                int width = m - j;
                int area = temp[j] * width;
                ans = Math.max(ans, area);
            }
        }

        return ans;
    }
}
