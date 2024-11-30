class Solution {  // O(n * log(n))   //stringbuilder -> O(n)
    public String frequencySort(String s) {
        Map<Character,Integer>charCount=new HashMap<>();
        for(char c : s.toCharArray()){
            charCount.put(c,charCount.getOrDefault(c,0)+1);
        }
    List<Character>character=new ArrayList<>(charCount.keySet());
      character.sort((a,b)->charCount.get(b)-charCount.get(a));
    

    StringBuilder result=new StringBuilder();
    for(char c:character){
        int frequency=charCount.get(c);  
        for(int i=0;i<frequency;i++){
            result.append(c);
        }
    }

        return result.toString();
    }
}