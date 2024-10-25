//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int ans = new Solution().rowWithMax1s(arr);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // public int rowWithMax1s(int arr[][]) {////brute force
    //   int count_max=0;
    //   int idx=-1;
       
    //   for(int i=0;i<arr.length;i++){
    //       int countOnes=0;
    //       for(int j=0;j<arr.length;j++){
    //           countOnes+=arr[i][0]+arr[0][j];
    //       }
    //       if(countOnes>count_max){
    //           count_max=countOnes;
    //           idx=i;
    //       }
    //   }
    //   return idx;
    // }
    

    public int rowWithMax1s(int[][] arr) {
        int maxCount = 0; 
        int idx = -1;      

        int n = arr.length;    // Number of rows
        int m = arr[0].length; // Number of columns

        for (int i = 0; i < n; i++) {
            int firstOneIdx = findFirstOne(arr[i], m); // Find the first occurrence of 1
            int countOnes;

            if (firstOneIdx == -1) {
                // If no 1s found, set countOnes to 0
                countOnes = 0;
            } else {
                // Otherwise, calculate the count of 1s in the row
                countOnes = m - firstOneIdx;
            }

            if (countOnes > maxCount) {
                // If the current row has more 1s than maxCount, update maxCount and idx
                maxCount = countOnes;
                idx = i;
            } 
        }
        return idx;
    }

    private int findFirstOne(int[] row, int m) {//usinglower bound method
        int low = 0;
        int high = m - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (row[mid] == 1) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans; 
    }
}
