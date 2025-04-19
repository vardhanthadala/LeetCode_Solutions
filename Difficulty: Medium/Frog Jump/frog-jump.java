//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize BufferedReader for efficient input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the number of test cases
        String str = br.readLine();
        int t = Integer.parseInt(str.trim());

        // Process each test case
        while (t-- > 0) {
            // Read the next line containing the array elements
            str = br.readLine();
            String[] tokens = str.trim().split("\\s+");

            // Convert the input strings to integers and store in an array
            ArrayList<Integer> list = new ArrayList<>();
            for (String token : tokens) {
                if (!token.isEmpty()) { // Ensure that the token is not empty
                    list.add(Integer.parseInt(token));
                }
            }

            // Convert ArrayList to int[] for processing
            int[] arr = list.stream().mapToInt(Integer::intValue).toArray();

            // Create an instance of Solution and compute the minimum energy
            Solution ob = new Solution();
            int result = ob.minCost(arr);

            // Output the result followed by a tilde as per the original C++ code
            System.out.println(result);
            System.out.println("~");
        }
    }
}


// } Driver Code Ends

// User function Template for Java

class Solution {
    //---------------Memoization O(n) O(n)-------------
    // int minCost(int[] height) {
    //     int n=height.length;
    //     int dp[]=new int[n];
    //   for (int i = 0; i < n; i++) { //initializing  array with -1
    //      dp[i] = -1;
    //   }

    //     return solve(n-1,height,dp);
       
    // }
    // private static int solve(int ind,int[] height,int[] dp){
    //     if(ind == 0) return 0;
    //     if(dp[ind]!=-1) return dp[ind];
        
    //     int jumpOne=solve(ind-1,height,dp)+Math.abs(height[ind]-height[ind-1]);
    //     int jumpTwo=Integer.MAX_VALUE;//its bcuz ,if idx is 1 ,if we go two steps then 1-2 is -1
    //     if(ind>1) jumpTwo=solve(ind-2,height,dp)+Math.abs(height[ind]-height[ind-2]);
        
    //     return dp[ind]=Math.min(jumpOne,jumpTwo);
    // }
    
    //------------Tabulation O(n) O(n) --------------------
    // int minCost(int[] height) {
    //     int n = height.length;
    //     int[] dp = new int[n];
    //     dp[0] = 0; // Base case: no cost at first stone

    //     for (int i = 1; i < n; i++) {
    //         int jumpOne = dp[i - 1] + Math.abs(height[i] - height[i - 1]);
    //         int jumpTwo = Integer.MAX_VALUE;
    //         if (i > 1) {
    //             jumpTwo = dp[i - 2] + Math.abs(height[i] - height[i - 2]);
    //         }
    //         dp[i] = Math.min(jumpOne, jumpTwo);
    //     }

    //     return dp[n - 1]; 
    // }
    
    //---------------space optimization O(n)O(1)-----------
    int minCost(int[] height){
        int n=height.length;
        int prev1=0;
        int prev2=0;
         
        for(int i=1;i<n;i++){
            int jump1=prev1+Math.abs(height[i]-height[i-1]);
            int jump2=Integer.MAX_VALUE;
            if(i>1) jump2=prev2+Math.abs(height[i]-height[i-2]);
            
            int curr_i=Math.min(jump1,jump2);
            prev2=prev1;
            prev1=curr_i;
        }
        return prev1;
        
    }
}


//{ Driver Code Starts.

// } Driver Code Ends