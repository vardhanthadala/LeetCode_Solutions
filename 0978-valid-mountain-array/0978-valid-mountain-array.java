class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = n - 1;
        if (n < 3) {
            return false;
        }
        while (i+1 < n && arr[i] < arr[i + 1]) {
            i++;
        }
        while (j > 0 && arr[j - 1] > arr[j]) {
            j--;
        }

        return i > 0 && i == j && j < n - 1;//The peak is not at the start &&  The peak is not at the end && The increasing and decreasing parts meet at the same peak index --> if this conditions satisfied its returns true else false
    }
}