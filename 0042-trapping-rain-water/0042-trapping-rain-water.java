class Solution {
    // public static int trap(int[] height) { //brute force t:O(N) s:O(N)
    //     int n = height.length;

    //     //Prefix
    //     int leftmax[] = new int[n];
    //     leftmax[0] = height[0];//starting indx
    //     for (int i = 1; i < n; i++) {
    //         leftmax[i] = Math.max(height[i], leftmax[i - 1]);
    //     }
    //     //Suffix 
    //     int rightmax[] = new int[n];
    //     rightmax[n - 1] = height[n - 1];//last indx
    //     for (int i = n - 2; i >= 0; i--) {
    //         rightmax[i] = Math.max(height[i], rightmax[i + 1]);
    //     }

    //     int trappedwater = 0;
    //     for (int i = 0; i < n; i++) {
    //         int waterlevel = Math.min(rightmax[i], leftmax[i]);
    //         trappedwater += waterlevel - height[i];
    //     }
    //     return trappedwater;
    // }

    public static int trap(int[] height) {//using 2 pointers T:O(n) S:O(1)

        int i = 0;
        int j = height.length - 1;
        int left_max = height[0];
        int right_max = height[j];

        int sum = 0;

        while (i < j) {
            if (left_max <= right_max) {
                sum += (left_max - height[i]);//water trapped at i
                i++; //move that damn left pointer
                left_max = Math.max(left_max, height[i]);
            } else {
                sum += (right_max - height[j]);//water trapped at j
                j--; //move the right pointer
                right_max = Math.max(right_max, height[j]);
            }
        }
        return sum;
    }
}