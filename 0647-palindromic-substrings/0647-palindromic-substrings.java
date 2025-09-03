class Solution {
    public int countSubstrings(String s) {//O(N^2) O(1) to optimise it use Manacher’s Algorithm
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            res += count_palindrome(s, i, i);
            res += count_palindrome(s, i, i + 1);
        }

        return res;        
    }

    private int count_palindrome(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }

}

