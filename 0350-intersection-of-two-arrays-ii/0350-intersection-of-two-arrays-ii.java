class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {//Map Time - O(n + m)  Space -  O(min(n, m))
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int num : nums1) {//count the occurancrs in nums1 for each element
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //Find match in nums2
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                result.add(num);
                map.put(num, map.get(num) - 1);// Without decreasing -->When we see 2 in nums2, its keep adding it even if nums1 didn’t have enough 2s.
            }
        }
        //converting result to array
        int[] output = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            output[i] = result.get(i);
        }

        return output;
    }
}