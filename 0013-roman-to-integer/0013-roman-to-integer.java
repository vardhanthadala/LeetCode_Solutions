class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

     int result = 0;
     for(int i=s.length()-1;i>=0;i--){
        int currVal=romanValues.get(s.charAt(i));

        if(i<s.length()-1 && currVal<romanValues.get(s.charAt(i+1))){
            result-=currVal;
        }else{
            result+=currVal;
        }
     }
     return result;
    }
}
