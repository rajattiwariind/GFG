class Solution {
    public int transform(String s1, String s2) {
        int n = s1.length();

        // Length must be equal
        if (n != s2.length()) {
            return -1;
        }

        // Check whether both strings have the same characters
        int[] count = new int[256];

        for (int i = 0; i < n; i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }

        for (int i = 0; i < 256; i++) {
            if (count[i] != 0) {
                return -1;
            }
        }

        int i = n - 1;
        int j = n - 1;
        int ans = 0;

        while (i >= 0) {
            // Skip characters that have to be moved to the front
            while (i >= 0 && s1.charAt(i) != s2.charAt(j)) {
                i--;
                ans++;
            }

            // Matching character stays in its relative position
            if (i >= 0) {
                i--;
                j--;
            }
        }

        return ans;
    }
}
