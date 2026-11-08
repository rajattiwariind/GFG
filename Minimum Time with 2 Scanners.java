class Solution {
    public int minTime(int n, int s1, int s2) {
        // code here
        int low = 1, high = Math.min(s1, s2) * n;
         while (low < high) {
             int mid = low + (high - low) / 2;
             if (mid / s1 + mid / s2 >= n) high = mid;
             else low = mid + 1;
         }
         return low;
    }
}
