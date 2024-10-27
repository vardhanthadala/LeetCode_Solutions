class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int res = 0;
        int maxf = 0;

        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            arr[s.charAt(r) - 'A']++;// counting no.of each character

            // Checking the character with max number of occurrence
            maxf = Math.max(maxf, arr[s.charAt(r) - 'A']);

            if (r - l + 1 - maxf > k) {//r - l + 1 - maxf calculates the number of characters in the current window that are not the most frequent character.//Total characters in the window minus the most frequent character count
                arr[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}