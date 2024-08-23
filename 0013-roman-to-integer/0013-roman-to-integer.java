class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> result = new HashMap<>();
        result.put('I', 1);
        result.put('V', 5);
        result.put('X', 10);
        result.put('L', 50);
        result.put('C', 100);
        result.put('D', 500);
        result.put('M', 1000);

int val = 0;
 for (int i = 0; i < s.length() - 1; i++) {
    if (result.get(s.charAt(i)) < result.get(s.charAt(i + 1))) {
                val -= result.get(s.charAt(i));
            } else {
                val += result.get(s.charAt(i));
            }
        }
        // Add the value of the last Roman numeral symbol
        val += result.get(s.charAt(s.length() - 1));
        
        return val;
    }
}

    