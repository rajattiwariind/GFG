class Solution {
    public int maxPackages(int[] arr, int totalTime) {
        // code here
        int n = arr.length;
        
        int rightSum = 0;
        int leftSum = 0;
        
        int i = 0;
        for( ; i < Math.min(totalTime, n); i++){
            rightSum += arr[i];
        }
        int ans = rightSum;
        int j = 0;
        
        for( ; i < n ; i++ , j++){
            rightSum += arr[i];
            leftSum += arr[j];
            
            ans = Math.max(ans , (rightSum - leftSum));
        }
        return ans;
    }
}
