class Solution {
    // -------------1.HashSet O(n) O(n) --------------------
    // public int findDuplicate(int[] nums) {
    // HashSet<Integer> set = new HashSet<>();

    // for (int num : nums) {
    // if (set.contains(num)) {
    // return num;
    // }
    // set.add(num);
    // }
    // return -1;
    // }

    // }

    // -----------------2.count O(n) O(n)----------------------
    // public int findDuplicate(int[] nums) {
    // int len = nums.length;
    // int count[] = new int[len + 1];
    // for (int i = 0; i < len; i++) {
    // count[nums[i]]++;
    // if (count[nums[i]] > 1) {
    // return nums[i];
    // }
    // }
    // return len;
    // }
    // }

    // --------------3.Sort O(nlogn) O(nlogn--------------------------
    // public int findDuplicate(int[] nums) {
    // Arrays.sort(nums);
    // for (int i = 1; i < nums.length; i++) {
    // if (nums[i] == nums[i - 1]) {
    // return nums[i];
    // }
    // }
    // return nums.length;
    // }
    // }

    // ----------4.Fast slow pointer O(n) O(1)---------------------
       public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}