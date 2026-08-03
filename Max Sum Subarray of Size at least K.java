class Solution {
    public int maxSumWithK(int[] arr, int k) {
        int n = arr.length;

        int[] maxEndHere = new int[n];

        // Kadane: maximum subarray sum ending at each index
        maxEndHere[0] = arr[0];
        for (int i = 1; i < n; i++) {
            maxEndHere[i] = Math.max(arr[i], maxEndHere[i - 1] + arr[i]);
        }

        // First window of size k
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int ans = windowSum;

        // Slide the window
        for (int i = k; i < n; i++) {
            windowSum += arr[i] - arr[i - k];

            ans = Math.max(ans, windowSum);
            ans = Math.max(ans, windowSum + maxEndHere[i - k]);
        }

        return ans;
    }
}
