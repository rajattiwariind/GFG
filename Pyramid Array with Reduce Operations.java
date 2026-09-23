class Solution {
    public int formPyramid(int[] arr) {
        int n = arr.length;
        long totalSum = 0;
        
        for (int x : arr) {
            totalSum += x;
        }
        
        int[] left = new int[n];
        int[] right = new int[n];
        
        // Compute left constraints
        left[0] = Math.min(arr[0], 1); // handling start bounds properly or just 1 depending on problem spec (arr[i] >= 1)
        // Wait, for index 0, standard pyramid starts at 1, but let's check: left[0] should be min(arr[0], 1) or just 1? 
        // Actually, the left constraint from the start is min(arr[0], 1). Let's use 1 if array starts with 1, or min(arr[0], 1).
        // Let's refine left[0] initialization:
        left[0] = 1; // Since height starts at 1
        for (int i = 1; i < n; i++) {
            left[i] = Math.min(arr[i], left[i - 1] + 1);
        }
        
        // Compute right constraints
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(arr[i], right[i + 1] + 1);
        }
        
        long maxPyramidSum = 0;
        
        // Find the maximum pyramid sum possible
        for (int i = 0; i < n; i++) {
            long peakHeight = Math.min(left[i], right[i]);
            long pyramidSum = peakHeight * peakHeight;
            maxPyramidSum = Math.max(maxPyramidSum, pyramidSum);
        }
        
        // Minimum cost = Total sum - Max possible pyramid sum
        return (int) (totalSum - maxPyramidSum);
    }
}
