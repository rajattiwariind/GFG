class Solution {
    public int largestSubsquare(char[][] mat) {
        int n = mat.length;
        if (n == 0) return 0;
        
        int[][] hor = new int[n][n];
        int[][] ver = new int[n][n];
        
        // Step 1: Fill hor and ver arrays
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 'X') {
                    hor[i][j] = (j == 0) ? 1 : hor[i][j - 1] + 1;
                    ver[i][j] = (i == 0) ? 1 : ver[i - 1][j] + 1;
                } else {
                    hor[i][j] = 0;
                    ver[i][j] = 0;
                }
            }
        }
        
        int maxLen = 0;
        
        // Step 2: Iterate from bottom-right to top-left to find the largest square
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int small = Math.min(hor[i][j], ver[i][j]);
                
                // Check if we can form a square larger than maxLen
                while (small > maxLen) {
                    // Check top and left borders of the square of size 'small'
                    int r = i - small + 1;
                    int c = j - small + 1;
                    
                    if (hor[r][j] >= small && ver[i][c] >= small) {
                        maxLen = small;
                        break;
                    }
                    small--;
                }
            }
        }
        
        return maxLen;
    }
}
