class Solution { //time:O(2^N)*N space:O(N)
    private void findCombination(int idx, int[] arr, int target, List<List<Integer>> ans, ArrayList<Integer> ds) {
        if (idx == arr.length) { // if index reaches to the end of the recursion tree
            if (target == 0) { // if target is zero, we found a combination that equals to te target
                ans.add(new ArrayList<Integer>(ds)); 
            }
            return;
        }
        
        // Pick the element if it's <= the target
        if (arr[idx] <= target) {
            ds.add(arr[idx]);
            findCombination(idx, arr, target - arr[idx], ans, ds); // pick element
            ds.remove(ds.size() - 1); // backtrack to remove last element to explore other combinations
        }
        
        // Don't pick the element and move to the next one
        findCombination(idx + 1, arr, target, ans, ds);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) { 
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(0, candidates, target, ans, new ArrayList<Integer>());
        return ans;
    }
}
