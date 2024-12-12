class Solution {
    public int repeatedStringMatch(String a, String b) {
int minRepeats=(int) Math.ceil((double) b.length() / a.length());        StringBuilder sb = new StringBuilder(a.repeat(minRepeats));  
        
        if (sb.toString().contains(b)) {
            return minRepeats;
        }
        
        sb.append(a);
        if (sb.toString().contains(b)) {
            return minRepeats + 1;
        }
        
        return -1; 
    }
}
