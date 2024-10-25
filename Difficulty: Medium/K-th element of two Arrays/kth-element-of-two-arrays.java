//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] arr1 = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                arr1[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] arr2 = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                arr2[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(k, arr1, arr2));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public long kthElement(int k, int arr1[], int arr2[]) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0;
        int j = 0;

        int count = 0;
        int ele = -1;
    
        while (i < n1 && j < n2) {
            if (arr1[i] <arr2[j]) {
                if (count == k-1)
                    ele = arr1[i];
                count++;
                i++;
            } else {
                if (count == k-1)
                    ele = arr2[j];
               
                count++;
                j++;
            }
        }
        while (i < n1) {
            if (count == k-1)
                ele = arr1[i];
           
            count++;
            i++;
        }
        while (j < n2) {
            if (count == k-1)
                ele = arr2[j];
           
            count++;
            j++;
        }
       return ele;
    }
}