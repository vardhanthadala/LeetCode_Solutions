class Solution {
    public int longestOnes(int[] nums, int k) {
        int start=0;
        int max=0;
        int countZero=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) countZero++;

          while(countZero>k){
            if(nums[start]==0) 
            countZero--;
             start++;
          }
          max=Math.max(max,i-start+1);
        }
        return max;
        
       }
}