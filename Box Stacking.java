import java.util.Arrays;

class Solution {
    static class Rotation implements Comparable<Rotation> {
        int height, width, length;
        long area; // Use long to prevent integer overflow for large dimensions (up to 10^6)

        Rotation(int height, int width, int length) {
            this.height = height;
            this.width = width;
            this.length = length;
            this.area = (long) width * length;
        }

        @Override
        public int compareTo(Rotation o) {
            // Sort in descending order of base area using Long.compare
            return Long.compare(o.area, this.area);
        }
    }

    public static int maxHeight(int[] height, int[] width, int[] length) {
        int n = height.length;
        Rotation[] boxes = new Rotation[6 * n];
        int idx = 0;

        // Generate all 6 possible orientations for each box
        for (int i = 0; i < n; i++) {
            int h = height[i];
            int w = width[i];
            int l = length[i];

            // 1. h as height, w and l as base (both orderings)
            boxes[idx++] = new Rotation(h, w, l);
            boxes[idx++] = new Rotation(h, l, w);

            // 2. w as height, h and l as base (both orderings)
            boxes[idx++] = new Rotation(w, h, l);
            boxes[idx++] = new Rotation(w, l, h);

            // 3. l as height, h and w as base (both orderings)
            boxes[idx++] = new Rotation(l, h, w);
            boxes[idx++] = new Rotation(l, w, h);
        }

        // Sort all rotations by base area in descending order
        Arrays.sort(boxes);

        int totalRotations = 6 * n;
        int[] dp = new int[totalRotations];
        int maxHeight = 0;

        // Initialize dp values with the height of each box rotation itself
        for (int i = 0; i < totalRotations; i++) {
            dp[i] = boxes[i].height;
        }

        // Compute optimized DP values (Longest Increasing Subsequence variant)
        for (int i = 0; i < totalRotations; i++) {
            for (int j = 0; j < i; j++) {
                // boxes[i] can be placed on top of boxes[j] if both base dimensions are strictly smaller
                if (boxes[i].width < boxes[j].width && boxes[i].length < boxes[j].length) {
                    if (dp[j] + boxes[i].height > dp[i]) {
                        dp[i] = dp[j] + boxes[i].height;
                    }
                }
            }
            maxHeight = Math.max(maxHeight, dp[i]);
        }

        return maxHeight;
    }
}
