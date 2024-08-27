class Solution {
    public int[] sortedSquares(int[] nums) {
      int n=nums.length;
      int []result=new int[n];

      for(int i=0;i<n;i++){
        nums[i]=nums[i]*nums[i];
      }  
      int left=0;
      int right=n-1;

      for(int i=n-1;i>=0;i--){
        if(nums[left]>nums[right]){
            result[i]=nums[left];
            left++;
        }else{
            result[i]=nums[right];
            right--;
        }
      }
      return result;
    }
}


    //  public int[] sortedSquares(int[] nums) {
    //     for (int i = 0; i < nums.length; i++) {
    //         nums[i] = nums[i] * nums[i];
    //     }
    //     Arrays.sort(nums);
    //     return nums;
    // }
//}