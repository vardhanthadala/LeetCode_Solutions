class Solution {   //O(M*N)     O(1)
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, left = 0;
        int bottom = m - 1, right = n - 1;

        while (top <= bottom && left <= right) {
            // top
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++;

          //right
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {            
                    //bottom
         for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--;
            }

            
      if (left <= right) {
           //left
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
              left++;
            }
        }

        return result;
    }
}
