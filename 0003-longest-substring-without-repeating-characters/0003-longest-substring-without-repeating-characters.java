class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            if (map.containsKey(currentChar) && map.get(currentChar) >= left) {// (map.get(currentChar) >= left) ensure that left only moves forward when encountering a character that’s already part of the current substring (between left and right

                left = map.get(currentChar) + 1;
            }

            map.put(currentChar, right);

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}