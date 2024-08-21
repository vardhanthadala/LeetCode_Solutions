class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0;
        int j=0;
        while(i<s.length()&&j<t.length()){
            if(s.charAt(i)==t.charAt(j++)){
                i++;
                
            }
            
        }
        return i==s.length();
        //If i == s.length(), then all the characters is s were matched to some character in t. Hence s is a subsequence of t.
    }
}