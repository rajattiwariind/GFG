class Solution {
    public void mergeTwoParts(int[] arr) {
        // code here
        int n = arr.length;
        
        int j = 1;
        while(j < n && arr[j] >= arr[j-1]){
            j++;
        }
        int i = 0;
        int iStopage = j;
        int[] temp = new int[n];
        int k = 0;
        while(i < iStopage && j < n){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }
        while(i < iStopage){
            temp[k++] = arr[i++];
        }
        while(j < n){
            temp[k++] = arr[j++];
        }
        
        for(int l = 0 ; l < n ; l++){
            arr[l] = temp[l];
        }
    }
}
