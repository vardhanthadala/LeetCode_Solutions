class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < arr[mid + 1]) {// Ascending part, peak is to the right
                low = mid + 1;
            } else {// Descending part, peak is at mid or to the left
                high = mid;
            }
        }
        return low;
    }
}