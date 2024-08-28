class Solution {
    public int findMin(int[] nums) {
    int left = 0;
        int right = nums.length - 1;

 // If the array is not rotated, the first element is the minimum
        if (nums[left] <= nums[right]) {
            return nums[left];
        }

        // Modified binary search to find the minimum element
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid is the minimum element
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            // Check if mid-1 is the minimum element
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
 // If the left half is sorted, search in the right half
            if (nums[left] < nums[mid]) {
                left = mid + 1;
            }
  // If the right half is sorted, search in the left half
            else {
                right = mid - 1;
            }
        }

        return -1; 
    }
    }