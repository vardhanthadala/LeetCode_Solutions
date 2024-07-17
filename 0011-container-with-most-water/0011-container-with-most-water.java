class Solution {
    //https://youtu.be/w7ftYsZtIbs?si=-uDLJgsXEyEvb7Oo
    public int maxArea(int[] height) {
     int left=0;
     int right=height.length-1;

     int maxArea=0;

     while(left<right){
        //area= length*breadth
        int area=Math.min(height[left],height[right]) * (right-left);

        maxArea=Math.max(maxArea,area);

        if(height[left]<height[right]){
            left++;
        }else{
            right--;
        }
     }
     return maxArea;   
    }
}