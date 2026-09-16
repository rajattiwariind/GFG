import java.util.*;

class Solution {
    public int dominantPairs(int[] arr) {
        int n = arr.length;
        int half = n / 2;

        // Sort only the second half
        int[] second = new int[half];
        System.arraycopy(arr, half, second, 0, half);

        Arrays.sort(second);

        long count = 0;

        // For every element in the first half,
        // find how many elements in second half satisfy:
        // arr[i] >= 5 * second[j]
        for (int i = 0; i < half; i++) {
            int low = 0;
            int high = half;

            while (low < high) {
                int mid = low + (high - low) / 2;

                if ((long) second[mid] * 5 <= arr[i]) {
                    // This element works, so search to the right
                    low = mid + 1;
                } else {
                    // This element doesn't work
                    high = mid;
                }
            }

            // low = number of valid elements
            count += low;
        }

        return (int) count;
    }
}
