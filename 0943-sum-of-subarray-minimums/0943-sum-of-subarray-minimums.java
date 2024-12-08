class Solution {
// public int sumSubarrayMins(int[] arr) { //brute force T:O(N^3) S:O(N)
//     int n = arr.length;
//     int sum = 0;
//     int mod = 1_000_000_007;

//     for (int i = 0; i < n; i++) {
//         for (int j = i; j < n; j++) {
//             int min = Integer.MAX_VALUE;
//             for (int k = i; k <= j; k++) {
//                 min = Math.min(min, arr[k]);
//             }
//             sum = (sum + min) % mod;
//         }
//     }
//     return sum;
// }
public int sumSubarrayMins(int[] arr){ //optimal  t:O(5N)  s:O(5N)
        int n = arr.length;
        long mod = 1000000007;
        
        // Arrays to store the previous smaller and next smaller element indices
        int[] prevSmallerOREqual = new int[n];
        int[] nextSmaller = new int[n];
        
        //  prevSmaller or equal element    // (>= arr[i])
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            prevSmallerOREqual[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        //  nextSmaller element      // (>arr[i])
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            nextSmaller[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        //  sum of minimums
        long result = 0;
        for (int i = 0; i < n; i++) {
            // The number of subarrays where arr[i] is the minimum element
            long leftCount = i - prevSmallerOREqual[i];
            long rightCount = nextSmaller[i] - i;
            result = (result + (arr[i] * leftCount * rightCount) % mod) % mod;
        }

        return (int) result;
    
  }
}