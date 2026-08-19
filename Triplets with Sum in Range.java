import java.util.*;

class Solution {

    // Counts triplets whose sum is <= target
    private long countLessOrEqual(int[] arr, long target) {
        int n = arr.length;
        long count = 0;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                long sum = (long) arr[i] + arr[left] + arr[right];

                if (sum <= target) {
                    // Since array is sorted, all elements from
                    // left+1 ... right will also form valid triplets.
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }

    public long countTriplets(int[] arr, int l, int r) {
        Arrays.sort(arr);

        // sum in [l, r]
        // = sum <= r - sum <= (l - 1)
        return countLessOrEqual(arr, r)
             - countLessOrEqual(arr, (long) l - 1);
    }
}
