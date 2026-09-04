import java.util.*;

class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        int n = arr.size();

        long windowSum = 0;

        // First window
        for (int i = 0; i < m; i++) {
            windowSum += arr.get(i);
        }

        long ans = windowSum;

        // Sliding window around the circle
        for (int i = m; i < n + m - 1; i++) {
            windowSum -= arr.get((i - m) % n);
            windowSum += arr.get(i % n);

            ans = Math.max(ans, windowSum);
        }

        return (int) ans;
    }
}
