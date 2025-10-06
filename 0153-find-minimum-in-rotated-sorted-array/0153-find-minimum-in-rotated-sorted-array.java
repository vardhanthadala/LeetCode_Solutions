class Solution {
    // public int findMin(int[] nums) { //Binary search
    //     int left = 0;
    //     int right = nums.length - 1;

    //     while (left <= right) {
    //         int mid = left + (right - left) / 2;
    //         // Case 1: Array is already sorted (no rotation in this part)
    //         if (nums[left] <= nums[right]) {
    //             return nums[left];
    //         }
    //         // Case 2: mid > mid+1 → rotation point is right after mid
    //         if (nums[mid] > nums[mid + 1]) {
    //             return nums[mid + 1];
    //         }
    //         // Case 3: mid-1 > mid → rotation point is at mid

    //         if (nums[mid - 1] > nums[mid]) {
    //             return nums[mid];
    //         }
    //         // Case 4: Decide which half to search

    //         if (nums[left] < nums[mid]) {// left half is sorted → min must be in right half
    //             left = mid + 1;
    //         } else { // right half is sorted → min must be in left half
    //             right = mid - 1;
    //         }
    //     }

    //     return -1;
    // }
    public int findMin(int[] nums) { // simple Binary search
        int n = nums.length;
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;// Minimum is in left half including mid
            }
        }
        return nums[low]; //finally loww == high

    }
}