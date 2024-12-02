class Solution {
    // public boolean isPalindrome(String s) {
    //     if (s.isEmpty()) {
    //         return true;
    //     }
    //     int start = 0;
    //     int last = s.length() - 1;
    //     while (start <= last) {
    //         char currFirst = s.charAt(start);
    //         char currLast = s.charAt(last);
    //         if (!Character.isLetterOrDigit(currFirst)) {
    //             start++;
    //         } else if (!Character.isLetterOrDigit(currLast)) {
    //             last--;
    //         } else {
    //             if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
    //                 return false;
    //             }
    //             start++;
    //             last--;
    //         }
    //     }
    //     return true;
    // }

    // using recursion
    public boolean isPalindrome(String s) {
        //clean the string : remove non-alphanumeric characters and convert to lowercase
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return checkPalindrome(s, 0);
    }

    private boolean checkPalindrome(String s, int i) {

        int n = s.length();

        if (i >= n / 2) { // rechead middle of the work --> valid palindrome
            return true;
        }
        // check character from both sides(left ,right)
        if (s.charAt(i) != s.charAt(n - 1 - i)) { // not a palindrome
            return false;
        }
        return checkPalindrome(s, i + 1);// return wt ever this function gives
    }
}