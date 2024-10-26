class Solution {
    //brute force using linear search O(N^2)  O(1)

    //  public static boolean linearSearch(int []a, int num) {
    //     int n = a.length; //size of array
    //     for (int i = 0; i < n; i++) {
    //         if (a[i] == num)
    //             return true;
    //     }
    //     return false;
    // }
    //  public int longestConsecutive(int[] nums) {
    //     int n = nums.length; 
    //     int longest = 1;
       
    //     for (int i = 0; i < n; i++) {
    //         int x = nums[i];
    //         int cnt = 1;
            
    //         while (linearSearch(nums, x + 1) == true) {
    //             x += 1;
    //             cnt += 1;
    //         }

    //         longest = Math.max(longest, cnt);
    //     }
    //     return longest;
    // }

    //optimal approach using HashSet  O(2*N)  O(N)
   public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);    //add elements to numSet
        }

        int longestStreak = 0;

        for (int num : numSet) {
            
            if (!numSet.contains(num - 1)) {  
              
                int currentStreak = 1;

                while (numSet.contains(num + 1)) {
                  num++;
                    currentStreak++;
                }

               
            longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
