class Solution {
    public String lexiString(String s) {
        int n = s.length();
        int i = 0, j = 1, k = 0;

        // Two-pointer minimum rotation algorithm
        while (i < n && j < n && k < n) {
            char charI = s.charAt((i + k) % n);
            char charJ = s.charAt((j + k) % n);

            if (charI == charJ) {
                k++;
            } else {
                if (charI > charJ) {
                    i += k + 1;
                } else {
                    j += k + 1;
                }
                
                // Keep the pointers distinct
                if (i == j) {
                    j++;
                }
                k = 0; // Reset matching prefix length
            }
        }

        // The smaller index marks the beginning of the optimal rotation
        int startPos = Math.min(i, j);
        
        // Reconstruct and return the rotated string
        return s.substring(startPos) + s.substring(0, startPos);
    }
}
