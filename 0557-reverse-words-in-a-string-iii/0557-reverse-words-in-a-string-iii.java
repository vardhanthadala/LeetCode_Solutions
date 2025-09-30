class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");//split by words

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            res.append(new StringBuilder(words[i]).reverse());

            if (i != words.length - 1) { //if its not last words add space b/w words
                res.append(" ");
            }
        }
        return res.toString();
    }
}