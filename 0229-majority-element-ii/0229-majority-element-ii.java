class Solution {
    // Extended Boyer Moore's Voting Algorithm
    public List<Integer> majorityElement(int[] nums) {
       int n=nums.length;
        int cnt1 = 0, cnt2 = 0; 
        int el1 = Integer.MIN_VALUE; 
        int el2 = Integer.MIN_VALUE; 

        
        //Step 1 : first pass only finds candidates, not guaranteed to be actual majority elements.
        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && el2 != nums[i]) {
                cnt1 = 1;
                el1 = nums[i];
            } else if (cnt2 == 0 && el1 != nums[i]) {
                cnt2 = 1;
                el2 = nums[i];
             } else if (nums[i] == el1) cnt1++;
               else if (nums[i] == el2) cnt2++;
            else {
                cnt1--; cnt2--;
            }
        }

        List<Integer> ls = new ArrayList<>();

        //Step 2: Reset counts → verify actual frequency
        cnt1 = 0; cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == el1) cnt1++;
            if (nums[i] == el2) cnt2++;
        }

        int mini = (int)(n / 3) + 1;
        if (cnt1 >= mini) ls.add(el1);
        if (cnt2 >= mini) ls.add(el2);
        
        return ls;
    }
}

// public List<Integer> majorityElement(int[] nums) {// O(N) //O(N)
// int n = nums.length;
// List<Integer> result = new ArrayList<>();
// Map<Integer, Integer> counts = new HashMap<>();

// for (int num : nums) {
// counts.put(num, counts.getOrDefault(num, 0) + 1);
// }

// for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
// if (entry.getValue() > n / 3) {
// result.add(entry.getKey());
// }
// }

// return result;
// }

// }