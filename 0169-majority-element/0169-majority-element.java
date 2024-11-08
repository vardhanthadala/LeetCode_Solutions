class Solution {
    // -----------------1.HashMap O(N) O(N)--------------------
    // public int majorityElement(int[] nums) {
    // int n = nums.length;
    // Map<Integer, Integer> counts = new HashMap<>();

    // for (int num : nums) {
    // counts.put(num, counts.getOrDefault(num, 0) + 1);
    // }

    // for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
    // if (entry.getValue() > n / 2) {
    // return entry.getKey();
    // }
    // }

    // // Return -1 if no such element is found
    // return -1;
    // }

    // }
    // -------------2.Moore Voting Algorithm O(N) O(1)----------------
    public int majorityElement(int[] nums) {
        int majority = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {// If count is 0, assign the current element as the new candidate
                majority = num;
            }
            if (num == majority) {// If the current element is the same as the candidate
                count++;
            } else {
                count--;
            }
        }
        return majority;
    }
}