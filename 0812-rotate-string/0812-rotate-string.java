class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){ //if both strings lengths are not equal then GOAL cannot be a rotation of S,then it returns false
            return false;
        }
        s+=s;//adding s with itself(s+s),it creates new string that contains every possible rotations of s
        return s.contains(goal);//check for substring of goal presents in s
    }
}