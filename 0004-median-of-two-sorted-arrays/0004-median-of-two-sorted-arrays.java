// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         int n = nums1.length;
//         int m = nums2.length;
//         int i = 0, j = 0, median1 = 0, median2 = 0;

//         // Find median.
//         for (int count = 0; count <= (n + m) / 2; count++) {
//             median2 = median1;
//             if (i != n && j != m) {
//                 if (nums1[i] > nums2[j]) {
//                     median1 = nums2[j++];
//                 } else {
//                     median1 = nums1[i++];
//                 }
//             } else if (i < n) {
//                 median1 = nums1[i++];
//             } else {
//                 median1 = nums2[j++];
//             }
//         }

//         // Check if the sum of n and m is odd.
//         if ((n + m) % 2 == 1) {
//             return (double) median1;
//         } else {
//             double ans = (double) median1 + (double) median2;
//             return ans / 2.0;
//         }
//     }
// }

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0;
        int j = 0;

        int n = (n1 + n2);
        int idx2 = n / 2; // idx2:half of total length
        int idx1 = idx2 - 1; // idx1:before element of idx2
        int count = 0;
        int idx1Ele = -1;
        int idx2Ele = -1;
        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                if (count == idx1)
                    idx1Ele = nums1[i];
                if (count == idx2)
                    idx2Ele = nums1[i];
                count++;
                i++;
            } else {
                if (count == idx1)
                    idx1Ele = nums2[j];
                if (count == idx2)
                    idx2Ele = nums2[j];
                count++;
                j++;
            }
        }
        while (i < n1) {
            if (count == idx1)
                idx1Ele = nums1[i];
            if (count == idx2)
                idx2Ele = nums1[i];
            count++;
            i++;
        }
        while (j < n2) {
            if (count == idx1)
                idx1Ele = nums2[j];
            if (count == idx2)
                idx2Ele = nums2[j];
            count++;
            j++;
        }
        if (n % 2 == 1) {
            return (double) idx2Ele;
        }
        return (double) (idx1Ele + idx2Ele) / 2.0;
    }
}