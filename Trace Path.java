class Solution {
    public boolean isPossible(int n, int m, String s) {
        // code here
        int rowmin=0;
        int rowmax=0;
        int colmin=0;
        int colmax=0;
        
        int row=0;
        int col=0;
        
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(c=='L')col--;
            else if(c=='R')col++;
            else if(c=='U')row--;
            else row++;
            
            rowmin=Math.min(rowmin,row);
            rowmax=Math.max(rowmax,row);
            colmin=Math.min(colmin,col);
            colmax=Math.max(colmax,col);
        }
        
        if(n>= rowmax-rowmin+1 && m>=colmax-colmin+1)return true;
        return false;
    }
}
