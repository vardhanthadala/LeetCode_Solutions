class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length; 
        int cols = matrix[0].length;
        int low = 0;
        int high = rows*cols-1;//total no.of elements
       
       if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false; 
        }

       while (low<=high){
        int mid=(low+high)/2;
        int midVal=matrix[mid/cols][mid%cols];

        if(midVal==target){
           return true; 
        }else if(target>midVal){
            low=mid+1;
        }else{
            high=mid-1;
        }
       }
    return false;
    }
}