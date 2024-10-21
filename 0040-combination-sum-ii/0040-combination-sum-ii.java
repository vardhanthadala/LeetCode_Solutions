class Solution { //time::O(2^n*k) space:O(k*x)
    private void findCombination(int idx, int[] arr, int target, List<List<Integer>> ans, ArrayList<Integer> ds) {
        if (target == 0) { // If target is zero, we found a valid combination
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i - 1]) { // Skipping duplicates elements
                continue;
            }
            if (arr[i] > target) { // If current element < target ..we dont need to proceed further..
                break;
            }

            ds.add(arr[i]); // Pick the current element
            findCombination(i + 1, arr, target - arr[i], ans, ds); // Move to the next element
            ds.remove(ds.size() - 1); // Backtrack to pick another element
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates); // sorting to handle duplicates
        findCombination(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

}
