class Solution {//  O(n) , O(n) ->bcuz of used stringbuilder  Optimal
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) { //if the current word is not the last word (i > 0), it also appends a space character to separate the words
                reversed.append(" ");
            }
        }
        return reversed.toString();
    }
    // public String reverseWords(String s) {
    //     int left = 0;
    //     int right = s.length() - 1;

    //     String temp = "";
    //     String ans = "";

    //     while (left <= right) {
    //         char ch = s.charAt(left);

    //         if (ch != ' ') { //if its a character
    //             temp += ch; // build the word
    //         } else if (ch == ' ') {//if its a space
    //             if (!temp.equals("")) { // only add if word exists
    //                 if (!ans.equals("")) { //if a word is already present then add curr word before it(Reverse order)
    //                     ans = temp + " " + ans;
    //                 } else {
    //                     ans = temp;
    //                 }
    //                 temp = ""; // reset for next word
    //             }
    //         }
    //         left++;
    //     }

    //     // Add the last word 
    //     if (!temp.equals("")) {//if last word is not empty
    //         if (!ans.equals("")) {// if ans already has some words
    //             ans = temp + " " + ans;
    //         } else {
    //             ans = temp;
    //         }
    //     }

    //     return ans;
    // }
}