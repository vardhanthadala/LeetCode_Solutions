class Solution {
    // Recursion (Little More Optimal) Time - O(n! * n) Space - O(n * n!)
    private void solve(int idx, int[] nums, List<List<Integer>> res) {

        List<Integer> ds = new ArrayList<>();

        if (idx == nums.length) {
            for (int x : nums) {
                ds.add(x);
            }
            res.add(new ArrayList<>(ds));
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            solve(idx + 1, nums, res);
            swap(nums, idx, i);// backtacking(back to previous state to explore all combinations)
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

    // Recurssion (Optimal) Time - O(n! * n) Space - O(n * n!)

//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> ans = new ArrayList<>();
//         List<Integer> ds = new ArrayList<>();
//         boolean freq[] = new boolean[nums.length];

//         recurPermute(nums, ds, ans, freq);
//         return ans;
//     }

//     private void recurPermute(int[] nums, List<Integer> ds, List<List<Integer>> ans, boolean[] freq) {

//         if (ds.size() == nums.length) { // if the arraylist ds size is equal to n , then we found a permutation
//             ans.add(new ArrayList<>(ds));
//             return;
//         }
//         for (int i = 0; i < nums.length; i++) {
//             if (!freq[i]) {
//                 freq[i] = true;
//                 ds.add(nums[i]);
//                 recurPermute(nums, ds, ans, freq);
//                 ds.remove(ds.size() - 1);
//                 freq[i] = false;
//             }
//         }

//     }
// }