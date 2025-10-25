class Solution {
    // public int[] twoSum(int[] numbers, int target) { // O(n) O(1)

    //     int left = 0, right = numbers.length - 1;

    //     while (left < right) {
    //         int sum = numbers[left] + numbers[right];

    //         if (sum == target) {
    //             return new int[]{left +1, right+1 }; 
    //         } else if (sum < target) {
    //             left++;
    //         } else {
    //             right--;
    //         }
    //     }

    //     return new int[]{-1, -1}; 

    // }
    public int[] twoSum(int[] numbers, int target) { //O(n) O(n)

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int req = target - numbers[i];

            if (map.containsKey(req)) {
                return new int[] { map.get(req), i + 1 };//i+1 for 1 based index
            }
            map.put(numbers[i], i + 1);//i+1 for 1 based index
        }

        return new int[] {};
    }
}