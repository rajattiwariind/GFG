class Solution {
    public boolean isPossible(int[] arr, int s, int x) {
        long total = s;
        long[] nums = new long[arr.length + 1];

        nums[0] = s;
        int count = 1;

        for (int a : arr) {
            long next = total + a;

            nums[count++] = next;
            total += next;

            // All future numbers will be even larger,
            // so they cannot be part of a sum <= x.
            if (next > x) {
                break;
            }
        }

        long remaining = x;

        // Greedily take the largest possible number.
        for (int i = count - 1; i >= 0; i--) {
            if (nums[i] <= remaining) {
                remaining -= nums[i];
            }

            if (remaining == 0) {
                return true;
            }
        }

        return false;
    }
}
