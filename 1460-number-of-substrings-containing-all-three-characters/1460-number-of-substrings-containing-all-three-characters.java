class Solution {
    public int numberOfSubstrings(String s) {
        int aIndex = -1;
        int bIndex = -1;
        int cIndex = -1;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a')
                aIndex = i;
            else if (ch == 'b')
                bIndex = i;
            else if (ch == 'c')
                cIndex = i;

            int substringsEndingHere = Math.min(aIndex, Math.min(bIndex, cIndex)) + 1;
            count += substringsEndingHere;
        }

        return count;
    }
}