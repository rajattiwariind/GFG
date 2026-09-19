class Solution {
    public int findMinCost(String s1, String s2, int costS1, int costS2) {
        int n = s1.length();
        int m = s2.length();
        
        // Find the length of the Longest Common Subsequence (LCS)
        int lcsLength = getLCSLength(s1, s2, n, m);
        
        // Calculate the minimum cost
        int totalCost = (n - lcsLength) * costS1 + (m - lcsLength) * costS2;
        return totalCost;
    }
    
    private int getLCSLength(String s1, String s2, int n, int m) {
        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            // Copy curr to prev for the next iteration
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev[m];
    }
}
