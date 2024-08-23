class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer>map=new HashMap<>();

        for(char c: magazine.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (char c : ransomNote.toCharArray()) {
            if(!map.containsKey(c) || map.get(c) == 0){// If the character is not available or already used 
                return false;
            }
            map.put(c,map.get(c)-1);//use the character
        }
    return true;
    }
}