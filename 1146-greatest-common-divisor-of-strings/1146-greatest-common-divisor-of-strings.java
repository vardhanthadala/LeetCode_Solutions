class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)){
            return"";
        }
                // If strings are equal than return the substring from 0 to gcd of size(str1), size(str2)
        int gcd=gcd(str1.length(),str2.length());
        return str1.substring(0,gcd);
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}