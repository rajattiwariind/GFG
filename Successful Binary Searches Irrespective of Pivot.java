class Solution {
    public int countAlwaysFound(int[] arr) {
        // code here
        int n = arr.length;
        
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        
        prefix[0] = arr[0];
        for(int i=1; i<n; i++){
            prefix[i] = Math.max(prefix[i-1], arr[i]);
        }
        suffix[n-1] = arr[n-1];
        for(int i=n-2; i>=0; i--){
            suffix[i] = Math.min(suffix[i+1], arr[i]);
        }
        int count = 0;
        for(int i=0; i<n; i++){
            boolean leftOk = (i==0) || (prefix[i-1] < arr[i]);
            boolean rightOk = (i== n-1) || (arr[i] < suffix[i+1]);
            
            if(leftOk && rightOk){
                count++;
            }
        }
        return count;
    }
}
