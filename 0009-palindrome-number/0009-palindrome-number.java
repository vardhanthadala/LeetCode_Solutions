class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        long reversed = 0;
        long temp = x;

        while (temp != 0) {
            int digit = (int) (temp % 10);//get last digit
            reversed = reversed * 10 + digit;// build reversed number
           temp /= 10;//remove last digit
        }

        return (reversed == x);
    }
}