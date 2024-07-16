class Solution {    //O(M+N)  //O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1=m-1;  //pointer1
        int p2=n-1;  //pointer2
        int p=m+n-1;  //pointer3

        while(p1>=0 &&p2>=0){
            if(nums1[p1]>=nums2[p2]){
                nums1[p]=nums1[p1];
                p1--;
            }else{
                nums1[p]=nums2[p2];
                p2--;
            }
            p--;
        }
        while(p2>=0){
            nums1[p]=nums2[p2];
            p2--;
            p--;
        }
    }
}