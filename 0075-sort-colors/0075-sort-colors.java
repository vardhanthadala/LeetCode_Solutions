class Solution {
    public void sortColors(int[] nums) {
     //step 1: 3 pointers for 0,1,2
     //step 2 : swap number to its places
     int low=0;
     int mid=0;
     int high=nums.length-1;

    while(mid<=high){
        if(nums[mid]==0){
            swap(nums,low,mid);
            low++;
            mid++;
        }else if(nums[mid]==1){
            mid++;
        }else{//nums[mid]==2
      swap(nums,high,mid);
         high--;
        }
    }

    }
    public static void swap(int nums[],int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}