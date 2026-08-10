class Solution {
    public int maxTask(int[] h, int[] l) {
        int n = h.length;

        int skip = 0;
        int take = 0;

        for (int i = 0; i < n; i++) {
            int newSkip = take;

            // Low-effort task
            int low = take + l[i];

            // High-effort task requires previous day to be skipped
            int high = skip + h[i];

            int newTake = Math.max(low, high);

            skip = newSkip;
            take = newTake;
        }

        return take;
    }
}
