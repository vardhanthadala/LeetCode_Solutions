class Solution {
    // ----------------1.HashMap O(N) O(N)----------------------
    // public int[] twoSum(int[] nums, int target) {

    // HashMap<Integer, Integer> map = new HashMap<>();

    // for (int i = 0; i < nums.length; i++) {
    // int req = target - nums[i];
    // if (map.containsKey(req)) {
    // return new int[] { map.get(req), i };
    // }
    // map.put(nums[i], i);
    // }

    // return new int[] { -1, -1 }; // No solution found
    // }
    // ----------------2.Two pointer O(NlogN) O(1)---------------------
  
    public int[] twoSum(int[] nums, int target) {
        int[][] sortedNums = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            sortedNums[i] = new int[]{i, nums[i]};
        }

        Arrays.sort(sortedNums, (a, b) -> Integer.compare(a[1], b[1]));

        int left = 0, right = nums.length - 1;

        while (left < right) {
            int currentSum = sortedNums[left][1] + sortedNums[right][1];

            if (currentSum == target) {
                return new int[]{sortedNums[left][0], sortedNums[right][0]};
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{};
    }
}