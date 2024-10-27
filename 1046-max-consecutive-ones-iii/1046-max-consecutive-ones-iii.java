class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int max=0;
        int countZero=0;

        for(int right=0;right<nums.length;right++){
            if(nums[right]==0){
                countZero++;
            } 

          while(countZero>k){//If countZero > k (meaning there are more zeroes than we’re allowed to flip), we shrink the window from the left by moving the left pointer to the right.
// We decrement countZero if nums[left] was zero since we’re removing a zero from the current window.
            if(nums[left]==0) 
            countZero--;
             left++;
          }
          max=Math.max(max,right-left+1);
        }
        return max;
        
       }
}