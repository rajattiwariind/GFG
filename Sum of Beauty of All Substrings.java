class Solution {
    public int beautySum(String s) {
        // code here
        int n = s.length();
        int ans = 0;
        
        for(int i = 0 ; i < n ; i++){
            int[] freq = new int[26];
            
            for(int j = i ; j < n ; j++){
                int minFreq = Integer.MAX_VALUE;
                int maxFreq = Integer.MIN_VALUE;
                char ch = s.charAt(j);
                freq[ch-'a']++;
                int freqArrSize = 0;
                for(int c = 0 ; c < 26 ; c++){
                    if(freq[c] > 0){
                        freqArrSize++;
                        minFreq = Math.min(minFreq , freq[c]);
                        maxFreq = Math.max(maxFreq , freq[c]);
                    }
                }
                if(freqArrSize > 1){
                    ans += (maxFreq - minFreq);
                }
            }
        }
        return ans;
    }
}
