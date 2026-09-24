import java.util.Arrays;

class Solution {
    static class Disc implements Comparable<Disc> {
        int radius, height;
        Disc(int radius, int height) {
            this.radius = radius;
            this.height = height;
        }
        @Override
        public int compareTo(Disc other) {
            if (this.radius != other.radius) {
                return Integer.compare(this.radius, other.radius);
            }
            return Integer.compare(this.height, other.height);
        }
    }

    static class FenwickTree {
        int[] tree;
        int size;

        FenwickTree(int size) {
            this.size = size;
            tree = new int[size + 1];
        }

        void update(int index, int val) {
            for (; index <= size; index += index & -index) {
                tree[index] = Math.max(tree[index], val);
            }
        }

        int query(int index) {
            int maxVal = 0;
            for (; index > 0; index -= index & -index) {
                maxVal = Math.max(maxVal, tree[index]);
            }
            return maxVal;
        }
    }

    public static int maxStackHeight(int[] r, int[] h) {
        int n = r.length;
        Disc[] discs = new Disc[n];
        for (int i = 0; i < n; i++) {
            discs[i] = new Disc(r[i], h[i]);
        }

        // Sort discs by radius, then by height
        Arrays.sort(discs);

        // Max height constraint is 1000
        FenwickTree bit = new FenwickTree(1000);
        int maxOverallHeight = 0;

        int i = 0;
        while (i < n) {
            int j = i;
            // Group all discs sharing the same radius
            while (j < n && discs[j].radius == discs[i].radius) {
                j++;
            }

            int[] currentDp = new int[j - i];
            
            // Step 1: Query max stack height for strictly smaller heights (< height)
            for (int k = i; k < j; k++) {
                int height = discs[k].height;
                int prevMax = bit.query(height - 1);
                currentDp[k - i] = height + prevMax;
            }

            // Step 2: Update the Fenwick tree with current group results
            for (int k = i; k < j; k++) {
                int height = discs[k].height;
                bit.update(height, currentDp[k - i]);
                maxOverallHeight = Math.max(maxOverallHeight, currentDp[k - i]);
            }

            i = j;
        }

        return maxOverallHeight;
    }
}
