//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        
System.out.println("~");
}
    }
}


// } Driver Code Ends


//User function Template for Java

 class Solution {

    private static int countPainters(int arr[], long maxTime) {
        int n = arr.length;
        int painters = 1; 
        long timeSpent = 0; 
        
        for (int i = 0; i < n; i++) {
            if (timeSpent + arr[i] <= maxTime) {
                // Add time to current painter
                timeSpent += arr[i];
            } else {
                // Assign the current section to the next painter
                painters++;
                timeSpent = arr[i]; // Reset to current section's time
            }
        }
        return painters;
    }

    static long minTime(int[] arr, int n, int k) {
        // If there are more painters than sections, it's impossible
       if (k >= n) {
            long maxTime = Long.MIN_VALUE;
            for (int time : arr) {
                maxTime = Math.max(maxTime, time);
            }
            return maxTime;
        }

        long low = Integer.MIN_VALUE; //  max elementi in arr
        long high = 0; // Sum of all sections
        
        for (int time : arr) {
            high += time; // Total time
            if (time > low) {
                low = time; // The largest single section time
            }
        }

        while (low < high) {
            long mid = (low + high) / 2; 
            int paintersNeeded = countPainters(arr, mid); 
            
            if (paintersNeeded > k) {
                low = mid + 1; // Increase the max time allowed
            } else {
                high = mid; // Try to lower the max time
            }
        }
        return low; // The smallest max time that allows k painters
    }
}


