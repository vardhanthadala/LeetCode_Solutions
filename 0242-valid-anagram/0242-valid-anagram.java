class Solution {

    // public boolean isAnagram(String s, String t) {//HashMap O(N) O(N)
    //     if (s.length() != t.length()) {
    //         return false;
    //     }
    //     HashMap<Character, Integer> sCount = new HashMap<>();
    //     HashMap<Character, Integer> tCount = new HashMap<>();

    //     for(int i=0;i<s.length();i++){
    //         sCount.put(s.charAt(i),sCount.getOrDefault(s.charAt(i),0)+1);
    //         tCount.put(t.charAt(i),tCount.getOrDefault(t.charAt(i),0)+1);
    //     }
    //     return sCount.equals(tCount);
    // }

    public boolean isAnagram(String s, String t) { //O(N) O(1)

        if (s.length() != t.length())
            return false;
        int count[] = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++; // Increment for s
            count[t.charAt(i) - 'a']--; // Decrement for t
        }
        for (int c : count) {
            if (c != 0)
                return false; // If any count is non-zero, not an anagram
        }
        return true;
    }

}