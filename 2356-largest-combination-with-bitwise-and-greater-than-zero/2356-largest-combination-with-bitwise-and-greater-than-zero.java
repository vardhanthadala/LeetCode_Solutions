class Solution {
    public int largestCombination(int[] candidates) {
        int max=0;
        for(int i=0;i<30;i++){
            int c=0;
            for(int x:candidates){
                if((x>>i&1)==1){
                    c++;
                }
            }
            max=Math.max(max,c);
        }
        return max;
    }
}