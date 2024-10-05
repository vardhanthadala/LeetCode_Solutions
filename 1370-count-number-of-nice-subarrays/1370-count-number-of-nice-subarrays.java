
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> countOdd = new HashMap<>();
       countOdd.put(0, 1); // Initialize  with one even number
        int oddCount = 0;
        int result = 0;

        for (int num : nums) {
            if (num % 2 == 1) {
                oddCount++;
            }

            result += countOdd.getOrDefault(oddCount - k, 0);

   countOdd.put(oddCount, countOdd.getOrDefault(oddCount, 0) + 1);
        }

        return result;
    }
}
