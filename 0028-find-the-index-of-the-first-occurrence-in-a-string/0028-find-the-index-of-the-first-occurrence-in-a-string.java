class Solution {
    // public static int strStr(String haystack, String needle) {
    //      return haystack.indexOf(needle);

    // }
    public static int strStr(String haystack, String needle){
        int n=haystack.length();
        int m=needle.length();

        if(m>n){
            return -1;
        }
        if(m==1  && n==1){
            return 0;
        }

        for(int i=0;i<=n-m;i++){
            int j=0;
            while(j<m && haystack.charAt(i+j)==needle.charAt(j)){
                j++;
            }
            if(j==m){
                return i;
            }
        }
        return -1;
    }
}