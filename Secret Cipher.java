class Solution {

    public String compress(String s) {
        int n = s.length();

        // KMP LPS array
        int[] lps = new int[n];

        for (int i = 1; i < n; i++) {
            int j = lps[i - 1];

            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = lps[j - 1];
            }

            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }

            lps[i] = j;
        }

        StringBuilder ans = new StringBuilder();

        int i = n - 1;

        while (i >= 0) {
            int len = i + 1;

            if (len % 2 == 0) {
                int border = lps[i];
                int period = len - border;

                if (border >= len / 2 &&
                    len % (2 * period) == 0) {

                    ans.append('*');

                    // Keep the first half
                    i = len / 2 - 1;
                    continue;
                }
            }

            ans.append(s.charAt(i));
            i--;
        }

        return ans.reverse().toString();
    }
}
