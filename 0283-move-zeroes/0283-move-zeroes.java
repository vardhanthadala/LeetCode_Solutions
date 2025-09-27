class Solution {
    // public void moveZeroes(int[] nums) {//O(n) O(n)
    //     int left=0;
    //     for(int right=0;right<nums.length;right++){
    //         if(nums[right] != 0){// Non zero element
    //             int temp= nums[left];
    //             nums[left]=nums[right];
    //             nums[right]=temp;

    //             left++;
    //         }

    //     }
    // }
    public void moveZeroes(int[] nums) {
        int lastNonZero = 0;

        //Step 1 : Move non zero elements forward
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZero] = nums[i];
                lastNonZero++;
            }
        }
        // Step 2 : Fill remaining positions with 0
        for (int i = lastNonZero; i < nums.length; i++) {
            nums[i] = 0;
        }

    }
}