class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ansList = new ArrayList<>();
        findSubsets(0, nums, new ArrayList<>(), ansList);
        return ansList;
    }

    public static void findSubsets(int idx, int nums[], List<Integer> arr, List<List<Integer>> ansList) {
        ansList.add(new ArrayList<>(arr));// at each recursion level the current subset(arr) is added to list(ansList)
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) {
                continue; // skipping duplicates
            }

            arr.add(nums[i]);//current element added to subset
            findSubsets(i + 1, nums, arr, ansList);
            arr.remove(arr.size() - 1);//backtracking to remove last element to vist all subsets
        }
    }
}
