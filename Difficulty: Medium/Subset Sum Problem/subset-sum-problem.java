//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    static Boolean isSubsetSum(int arr[], int target) {
        // code here
      return  subsetSumHelper(arr,target,0,0);
    }

    private static boolean subsetSumHelper(int arr[],int target,int idx,int currSum){
        if(currSum==target){
            return true;
        }
        
        // Base case: if we've processed all elements or the current sum exceeds target
        if (idx == arr.length || currSum > target) {
            return false;
        }
         if (subsetSumHelper(arr, target, idx + 1, currSum + arr[idx])) {
            return true;
        }

        // 2. Exclude the current element from the subset
        if (subsetSumHelper(arr, target, idx + 1, currSum)) {
            return true;
        }
        return false;
    }
}