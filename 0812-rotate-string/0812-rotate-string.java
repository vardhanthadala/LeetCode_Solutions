class Solution {      //note //O(N) ,O(N)
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }
       String  rotatedS=s;
        for(int i=0;i<s.length();i++){
            if(rotatedS.equals(goal)){    // s (characters)==goal (characters)
                return true;
            }
            rotatedS=rotatedByOne(rotatedS) ; //rotating by one
        }
        return false;
    }
    public String  rotatedByOne(String str){  //method for rotation
        return str.substring(1)+ str.charAt(0); //This function takes the input string str, removes the first character with str.substring(1), and appends it to the end with str.charAt(0). It essentially simulates the rotation of the string by one position to the left.
    }
}