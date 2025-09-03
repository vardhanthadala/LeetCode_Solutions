class Solution {
    //     public int lengthOfLongestSubstring(String s) {//set + sliding window O(N) )(M)
    //         int n = s.length();
    //         int maxLen = 0;

    //         Set<Character> set = new HashSet<>();
    //         int left = 0;
    //         for (int right = 0; right < n; right++) {
    //             if (!set.contains(s.charAt(right))) { //First time character appearance
    //                 set.add(s.charAt(right));
    //                 maxLen = Math.max(maxLen, right - left + 1);
    //             } else { //if its not first time
    //                 while (set.contains(s.charAt(right))) {
    //                     set.remove(s.charAt(left));//remove left character from set
    //                     left++;
    //                 }
    //                 set.add(s.charAt(right)); // add right character in set

    //             }
    //         }
    //         return maxLen;
    //     }
    // }
    public int lengthOfLongestSubstring(String s) { //Array + sliding window O(N) O(1)
        int n = s.length();
        int maxLen = 0;

        int[] charIdx = new int[128];
        Arrays.fill(charIdx, -1);
        //left -> marks start of curr window
        //right ->marks end of curr window
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (charIdx[s.charAt(right)] >= left) { // If character at right was seen inside current window, move left pointer
                left = charIdx[s.charAt(right)] + 1;
            }
            charIdx[s.charAt(right)] = right;//This line updates the array to say: "The character s.charAt(right) was last seen at index right."
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;

    }

}