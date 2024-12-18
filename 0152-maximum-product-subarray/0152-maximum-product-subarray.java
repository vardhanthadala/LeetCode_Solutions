class Solution {
    public int maxProduct(int[] nums) {
        // odd negatives product --> negative val
        // even negatives product --> positive val
        // if it has zeros --> answer will be zero
        int prefix = 1;
        int suffix = 1;
        int ans = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (prefix == 0)prefix = 1; // if product of prefix is 0,then assign prefix with 1 for futher multiplication
            if (suffix == 0)suffix = 1;// if product of suffix is 0,then assign suffix with 1 for futher multiplication

            prefix = prefix * nums[i];
            suffix = suffix * nums[n - i - 1];

            ans = Math.max(ans, Math.max(prefix, suffix));
        }
        return ans;
    }
}