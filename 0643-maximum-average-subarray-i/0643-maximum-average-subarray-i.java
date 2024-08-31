class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max=Integer.MIN_VALUE;
        double sum=0;
        int start=0;

        for(int end=0;end<nums.length;end++){
            sum+=nums[end];

            if(end-start+1==k){
                max=Math.max(max,sum/k);  //avg= sum/length
                sum-=nums[start];//removing first element and adding 5th element (if k=4)
                start++;
            }
        }
        return max;
    }
}