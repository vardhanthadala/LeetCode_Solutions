class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] indexS = new int[200];
        int[] indexT = new int[200];

        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (indexS[s.charAt(i)] != indexT[t.charAt(i)] ){//current inndex of s is different from t
                return false;
            }

            indexS[s.charAt(i)] = i + 1;//update index of current character
            indexT[t.charAt(i)] = i + 1;//update index of current character
        }
        return true;
    }
}