class Solution {
    int getCount(String s, int k) {
        int[] freq = new int[26];
        int n = s.length(), i = 0;

        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            freq[s.charAt(i) - 'a']++;
            i = j;
        }

        int count = 0;
        for (int x : freq) {
            if (x == k) count++;
        }

        return count;
    }
}
