class Solution {
    public int thirdMax(int[] nums) {
        Long first = null, second = null, third = null;

        for (int n : nums) {
            long num = (long) n;

            // Skip duplicates
            if ((first != null && num == first) || 
                (second != null && num == second) || 
                (third != null && num == third)) {
                continue;
            }

            if (first == null || num > first) {
                third = second;
                second = first;
                first = num;
            } else if (second == null || num > second) {
                third = second;
                second = num;
            } else if (third == null || num > third) {
                third = num;
            }
        }

        // If we don't have 3 distinct numbers, return the maximum
        return third == null ? first.intValue() : third.intValue();
    }
}
