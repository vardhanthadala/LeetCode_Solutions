class Solution {
    public int[] plusOne(int[] digits) {
        //strt iterating from right most digit
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;//add one
            if (digits[i] < 10) {
                return digits;//no carry -> return result
            }
            digits[i] = 0;//Set current digit to 0 and continue carry
        }
        // if  in any case all digits were 9, we need an extra digit at the front
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}