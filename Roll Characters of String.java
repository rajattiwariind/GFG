class Solution {
    public String findRollOut(String s, int[] roll) {
        // code here
        int n = s.length();
        int[] cumArr = new int[n];
        for(int r : roll){
            cumArr[0]++;
            if(r < n){
                cumArr[r] -= 1;
            }
        }
        int cumSum = 0;
        for(int i = 0 ; i < n ; i++){
            cumSum += cumArr[i];
            cumArr[i] = cumSum;
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            int finalVal = ((int)(ch-'a') + cumArr[i]) % 26;
            char newChar = (char)('a' + finalVal);
            res.append(newChar);
        }
        return res.toString();
    }
}
