class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){//if both lengths are different ..
            return false;
        }
         Map<Character, Integer> charCountMap = new HashMap<>();

         for(char c : s.toCharArray()){
            charCountMap.put(c,charCountMap.getOrDefault(c,0)+1);
         }
         //if character in t not found in s
         for(char c: t.toCharArray()){
            if(!charCountMap.containsKey(c)){
                return false;
            }
             charCountMap.put(c, charCountMap.get(c) - 1);
                if (charCountMap.get(c) < 0) {
            return false;  // More occurrences of character in t than in s
            }
         }
        return true;
    }
}