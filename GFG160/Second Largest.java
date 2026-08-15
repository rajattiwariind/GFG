class Solution {
    public int getSecondLargest(int[] arr) {
        int largest =-1;
        int secondlargest =-1;
        
        for (int num: arr){
            if (num > largest){
                secondlargest = largest;
                largest = num;
            }else if (num > secondlargest && num < largest){
                secondlargest = num;
            }
        }
        return secondlargest;
    }
}
