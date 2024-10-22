class Solution {
    static void solve(int idx, int[] nums, List<List<Integer>> res) {
        if (idx == nums.length) {
            List<Integer> ds = new ArrayList<>();
            for (int x : nums) {
                ds.add(x);
            }
            res.add(new ArrayList<>(ds));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            solve(idx + 1, nums, res);
            swap(nums, idx, i);//backtacking (after exploring one possible permutation , the array is returned to its original state so that the algorithm can explore other permutations without being affected by previous swaps)

        }
    }

    static int[] swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return nums;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        solve(0, nums, res);
        return res;
    }
}