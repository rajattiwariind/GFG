class Solution {
    public int maximumSubarray(int[] arr) {
        // code here
        
            int dp0 = arr[0];
        int dp1 = arr[0] * arr[0];

        int ans = Math.max(dp0, dp1);

        for (int i = 1; i < arr.length; i++) {

            int x = arr[i];

            int newDp1 = Math.max(
                x * x,
                Math.max(
                    dp0 + x * x,
                    dp1 + x
                )
            );

            int newDp0 = Math.max(x, dp0 + x);

            dp0 = newDp0;
            dp1 = newDp1;

            ans = Math.max(ans, Math.max(dp0, dp1));
        }

        return ans;
    }
}
