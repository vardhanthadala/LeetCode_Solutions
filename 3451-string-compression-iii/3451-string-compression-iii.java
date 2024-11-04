class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int ind = 0;

        while (ind < word.length()) {
            int cnt = 0;
            char currChar = word.charAt(ind);

            while (ind < word.length() && word.charAt(ind) == currChar && cnt < 9) {
                cnt++;
                ind++;
            }

            comp.append(cnt).append(currChar);
        }

        return comp.toString();
    }
}