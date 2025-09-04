// class Solution {
//     public int firstUniqChar(String s) {
//         HashMap<Character, Integer> MAP = new HashMap<>();
//         for (char c : s.toCharArray()) {
//             map.put(c, hm.getOrDefault(c, 0) + 1);
//         }
//         for (int i = 0; i < s.length(); i++) {
//             if (hm.get(s.charAt(i)) == 1) {
//                 return i;
//             }
//         }
//         return -1;
//     }
// }
class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
