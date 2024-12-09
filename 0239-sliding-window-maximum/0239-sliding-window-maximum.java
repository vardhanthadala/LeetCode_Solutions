class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            // Remove Out-of-Window Indices
            if (!queue.isEmpty() && queue.peekFirst() <= i - k) {
                queue.removeFirst();
            }

            // Maintain Decreasing Order in the Deque
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.removeLast();
            }

            queue.addLast(i);
            // Add the Maximum Value to the Result List
            if (i >= k - 1) {
                list.add(nums[queue.peekFirst()]);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}