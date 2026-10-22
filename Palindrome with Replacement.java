class Solution {
    public int minimumSum(String s) {
        // code here
        StringBuilder sb = new StringBuilder(s);
        
        int n = s.length()-1;
        for(int i = 0 ; i <= n ; i++){
            char ch = sb.charAt(i);
            if(ch == '?') continue;
            
            int opIdx = n-i;
            if(sb.charAt(opIdx) != '?' && sb.charAt(opIdx) != ch){
                return -1;
            }else if(sb.charAt(opIdx) == '?'){
                sb.setCharAt(opIdx , ch);
            }
        }
        int ans = 0;
        char prevChar = '*';
        for(int i = 0 ; i < sb.length() ; i++){
            char ch = sb.charAt(i);
            if(ch == '?') continue;
            
            if(prevChar != '*'){
                ans += Math.abs((int)(ch - prevChar));
            }
            prevChar = ch;
        }
        return ans;
        
    }
}
