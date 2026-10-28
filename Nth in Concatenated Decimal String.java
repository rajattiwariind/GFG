class Solution {
    public char nthCharacter(int n) {
        long target = n; 
        long len = 1;    
        long count = 9;  
        long start = 1; 

        while (target > len * count) {
            target -= len * count;
            len++;               
            count *= 10;
            start *= 10;
        }
        long num = start + (target - 1) / len;
        String s = Long.toString(num);
        int index = (int) ((target - 1) % len);
        return s.charAt(index);
    }
}
