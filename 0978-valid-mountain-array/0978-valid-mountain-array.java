class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = n - 1;
        if (n < 3) {
            return false;
        }
        // Step 1: climb up
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }
        // Step 2: climb down
        while (j > 0 && arr[j - 1] > arr[j]) {
            j--;
        }
        // Step 3: check if both meet at same peak and peak is not at edges

        return i > 0 && i == j && j < n - 1;
    }
}