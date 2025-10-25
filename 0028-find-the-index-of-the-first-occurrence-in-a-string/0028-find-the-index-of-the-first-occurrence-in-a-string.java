class Solution {
    // public static int strStr(String haystack, String needle) {
    //      return haystack.indexOf(needle);

    // }
    // public int strStr(String haystack, String needle) {
    //     int haylength = haystack.length();
    //     int needlelength = needle.length();
    //     if (haylength < needlelength) {
    //         return -1;
    //     }
    //     for (int i = 0; i <= haylength - needlelength; i++) {//haylength - needlelength --> We’re checking every possible starting index i in haystack where needle could fit completely.
    //         int j = 0;
    //         while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j))//if we use :- haystack.charAt(i) thn it does not move with j
    //             j++;
    //         if (j == needle.length()) {
    //             return i;
    //         }
    //     }
    //     return -1;
    // }
    public int strStr(String haystack, String needle){
        for(int i=0;i<haystack.length()-needle.length()+1;i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                if(haystack.substring(i,needle.length()+i).equals(needle)){
                    return i;
                }
            }
        }
        return -1;
    }
}