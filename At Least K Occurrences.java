class Solution {
    public int firstElementKTime(int[] arr, int k) {
        // write code
        HashMap<Integer,Integer> map= new HashMap<> ();
        for(int a : arr)
        {
            map.put(a,map.getOrDefault(a,0)+1);
            if(map.get(a)==k)
            {
                return a;
            }
        }
        return -1;
    }
}
