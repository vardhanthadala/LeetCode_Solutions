class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return countsubArrays(nums, k) - countsubArrays(nums, k - 1);
    }

    private int countsubArrays(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int cntOdd = 0;
        int ans= 0;

        if (k < 0) {
            return 0;
        }

        while (r < nums.length) {
            if(nums[r]%2==1){
                cntOdd++;
            }
            while (cntOdd > k) {
               if(nums[l]%2==1){
                cntOdd--;
               }
                l++;
            }
            ans += (r - l + 1);
            r++;
        }
        return ans;
    }
}
