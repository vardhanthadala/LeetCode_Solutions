class Solution {// tricky question
    public int minChanges(String s) {
        int i = 0;
        int count = 0;
        while (i < s.length()) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                count++;
            }
            i += 2; // skipping to index+2 because we already checked i and i+1 so now (i+=2 ) makes
                    // i to compare (i+2 , i+3) then skips( i+2 , i+3) the checks (i+4,i+5...)
                    // pairwisely
        }

        return count;
    }
}