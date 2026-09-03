class Solution {
    public long maxDiffSum(int[] arr) {
        long dp0 = 0;
        long dp1 = 0;

        for (int i = 1; i < arr.length; i++) {
            long newDp0 = Math.max(
                dp0 + Math.abs(arr[i] - arr[i - 1]),
                dp1 + Math.abs(arr[i] - 1)
            );

            long newDp1 = Math.max(
                dp0 + Math.abs(1 - arr[i - 1]),
                dp1
            );

            dp0 = newDp0;
            dp1 = newDp1;
        }

        return Math.max(dp0, dp1);
    }
}
