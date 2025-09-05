class Solution {
    //calculate left total : ->  we just add current number(= pivot number) to left total because when we iterate through input array from index 0 and move to next number, pivot number should be part of left total next time.

   //calculate right total : -> substract left total and pivot number from whole total.

    public int pivotIndex(int[] nums) {
        int total=0;
        for(int num:nums){
            total+=num;
        }

        int leftTotal =0;
        for(int i=0;i<nums.length;i++){
            int rightTotal=total-leftTotal-nums[i];

            if(rightTotal==leftTotal){
                return i;// pivot index found
            }
            leftTotal+=nums[i];
        }
        return -1;
    }
}