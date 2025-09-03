class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // Case 1: Array is already sorted (no rotation in this part)
            if (nums[left] <= nums[right]) {
                return nums[left];
            }
            // Case 2: mid > mid+1 → rotation point is right after mid
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            // Case 3: mid-1 > mid → rotation point is at mid

            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            // Case 4: Decide which half to search

            if (nums[left] < nums[mid]) {// left half is sorted → min must be in right half
                left = mid + 1;
            } else { // right half is sorted → min must be in left half
                right = mid - 1;
            }
        }

        return -1;
    }
}