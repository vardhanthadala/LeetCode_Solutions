class Solution {
    public int myAtoi(String s) {
        int result = 0;
        int i = 0;
        int sign = 1;
        int n = s.length();

        // Ignore spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // check for +ve or -ve signs
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Convert chars to int
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

        // Check for integer overflow/underflow
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}
