class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        
        int start = 0, end = 0; 
        
        for (int i = 0; i < s.length(); i++) {
            // Check for odd-length palindrome ex: aba
            int len1 = expandAroundCenter(s, i, i);
            // Check for even-length palindrome centered between i and i + 1  ex: abba
            int len2 = expandAroundCenter(s, i, i + 1);
            
            
            int len = Math.max(len1, len2);
            
        
            if (len > end - start) { //end - start is the current longest palindrome length - 1 
                start = i - (len - 1) / 2; //starting index of palindrome
                end = i + len / 2;//ending index of palindrome
            }
        }
        
        // Extract and return the longest palindromic substring
        return s.substring(start, end + 1);
    }
    
    // Expand around the center and return the length of the palindrome
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return the length of the palindrome
        return right - left - 1;
    }
}
