class Solution {
    public int repeatedStringMatch(String a, String b) {
        int repeat = (b.length() - 1) / a.length() + 1;  
        StringBuilder sb = new StringBuilder(a.repeat(repeat));  
        
        if (sb.toString().contains(b)) {
            return repeat;
        }
        
        sb.append(a);
        if (sb.toString().contains(b)) {
            return repeat + 1;
        }
        
        return -1; 
    }
}
