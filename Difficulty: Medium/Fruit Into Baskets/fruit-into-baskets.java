//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            // Convert ArrayList to array
            Integer[] arr = new Integer[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call totalFruits method and print result
            Integer ans = ob.totalFruits(arr);
            System.out.println(ans);
        }
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int totalFruits(Integer[] arr) {
      int n = arr.length;  // In Java, use arr.length instead of arr.size()
        int maxLen = 0;  // Variable to store the maximum length
        HashMap<Integer, Integer> map = new HashMap<>();
          int left = 0, right = 0; 

        while (right < n) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);  // Increment count of arr[right]

            if (map.size() > 2) {//if map has more than 2 different numbers
                map.put(arr[left], map.get(arr[left]) - 1);  // remove left element
                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);  // Remove if count becomes 0
                }
                left++;  
            }

             if (map.size() <= 2) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            right++;  
        }

        return maxLen;  
    }
}