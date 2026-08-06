class Solution {
    public int countMinOperations(int[] arr) {
        int increments = 0;
        int maxDoublings = 0;

        for (int x : arr) {
            increments += Integer.bitCount(x);

            if (x > 0) {
                int doublings = 31 - Integer.numberOfLeadingZeros(x);
                maxDoublings = Math.max(maxDoublings, doublings);
            }
        }

        return increments + maxDoublings;
    }
}
