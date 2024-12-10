class Solution {
   public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

       
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));//comparator sorts by frequency

        for (int key : map.keySet()) {
            heap.add(key);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(heap.poll()); // Poll the element with the highest frequency
        }

        // Convert List to array and return the result
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = ans.get(i);
        }
        return result;
    }
}