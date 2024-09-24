class Solution {
    public int maxDepth(String s) {  //O(N)  O(1)
       int counter=0;
       int maxCounter=0;
       for(int i=0;i<s.length();i++){
           if(s.charAt(i)=='('){
               counter++;
           }
           else if(s.charAt(i)==')'){
               counter--;
           }else{
               continue;
           }
           maxCounter=Math.max(maxCounter,counter);
       } 
       return maxCounter;
    }
}