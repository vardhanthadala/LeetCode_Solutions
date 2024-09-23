class Solution {//  O(n) , O(n) ->bcuz of used stringbuilder
    public String reverseWords(String s) {
      String []words=s.trim().split("\\s+");
      StringBuilder reversed=new StringBuilder();
 for (int i = words.length - 1; i >= 0; i--) {
 reversed.append(words[i]);
 if(i>0){ //f the current word is not the last word (i > 0), it also appends a space character to separate the words
     reversed.append(" ");
 }
  }
     return reversed.toString();
    }
}