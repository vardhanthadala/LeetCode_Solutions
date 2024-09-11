class Solution {//2 solns  (1.recursion,2.bit manipulation)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>result=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<(1<<n);i++){  //1<<n --> number of subsets
            List<Integer>subset=new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i&(1<<j))>0){ //set
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }
        return result;
    }
}