class Solution {
    //the capacity is between max element in weights array and sum of all elements
    private static int findDays(int []weights,int capacity){
        int days=1;
        int load=0;
        

        for(int i=0;i<weights.length;i++){
            if(load+weights[i]>capacity){
                days+=1; //if capacity exceeds then move to next day
                load=weights[i];//load the weight
            }else{
                load+=weights[i]; //load the weights on same day
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        //now find maximum element in weights and total summation of weights 

        int low=Integer.MIN_VALUE;
        int high=0;

        for(int i=0;i<weights.length;i++){
             high+=weights[i]; // summation of weights --> high
            low=Math.max(low,weights[i]); //max weight    --> low
        }
        while(low<=high){
            int mid=(low+high)/2;
            if(findDays(weights,mid)<=days){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}