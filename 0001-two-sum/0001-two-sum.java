class Solution {
    // ----------------1.HashMap O(N) O(N)----------------------
    // public int[] twoSum(int[] nums, int target) {

    // HashMap<Integer, Integer> map = new HashMap<>();

    // for (int i = 0; i < nums.length; i++) {
    // int req = target - nums[i];
    // if (map.containsKey(req)) {
    // return new int[] { map.get(req), i };// return indices
    // }
    // map.put(nums[i], i);
    // }

    // return new int[] { -1, -1 }; // No solution found
    // }
    // ----------------2.Two pointer  O(N) + O(N*logN)), O(1)---------------------
  
    public int[] twoSum(int[] nums, int target) {
        // Storing value + original index
        int[][] arr = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = i;         // Index
            arr[i][1] = nums[i];   // Value
        }

        //Sort by Valueess...
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));//sort  based on the second element ([1]) of each sub-array

        int left = 0, right = nums.length - 1;

        while (left < right) {
            int currentSum = arr[left][1] + arr[right][1]; //vals

            if (currentSum == target) {
                return new int[]{arr[left][0], arr[right][0]};//idxs
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{};
    }
}