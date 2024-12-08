class Solution {
    // pre req -> https://leetcode.com/problems/sum-of-subarray-minimums/

  public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
    }

    // Helper method to calculate the sum of subarray minimums
    public long sumSubarrayMins(int[] arr) {
        int n = arr.length;

        int[] prevSmallerOREqual = new int[n];
        int[] nextSmaller = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            prevSmallerOREqual[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nextSmaller[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            long leftCount = i - prevSmallerOREqual[i];
            long rightCount = nextSmaller[i] - i;
            result = (result + (long) arr[i] * leftCount * rightCount) ;
        }

        return result;
    }

    // Helper method to calculate the sum of subarray maximums
    public long sumSubarrayMaxs(int[] arr) {
        int n = arr.length;

        int[] prevGreaterOREqual = new int[n];
        int[] nextGreater = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            prevGreaterOREqual[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            nextGreater[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            long leftCount = i - prevGreaterOREqual[i];
            long rightCount = nextGreater[i] - i;
            result += (long) arr[i] * leftCount * rightCount;
        }

        return result;
    }
}