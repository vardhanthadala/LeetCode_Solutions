class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        if (nums == null || nums.length == 0) {

        return 0;
        }
        Map<Integer, Integer> remainderFreq = new HashMap<>();
        remainderFreq.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum = (sum + num) % k;
        if (sum < 0) sum += k; // To handle  -ve remainders
            
            if (remainderFreq.containsKey(sum)) {
                count += remainderFreq.get(sum);
            }

     remainderFreq.put(sum, remainderFreq.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}