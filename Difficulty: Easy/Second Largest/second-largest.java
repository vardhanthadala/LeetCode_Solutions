//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSecondLargest(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
     public int getSecondLargest(int[] arr) {
        int firstLargest=Integer.MIN_VALUE;
        int secondLargest=Integer.MIN_VALUE;
        int n=arr.length;

        if(n<2) return -1;
        
        
        for(int i=0;i<n;i++){
            if(arr[i]>firstLargest){
                secondLargest=firstLargest;
                firstLargest=arr[i];
            }else if(arr[i] > secondLargest && arr[i] != firstLargest){
                secondLargest=arr[i];
            }
        }
        // If secondLargest is still Integer.MIN_VALUE or if all elements are the same, return -1
         if (secondLargest == Integer.MIN_VALUE || secondLargest == firstLargest) {
            return -1;
        }
        return secondLargest;
    }
}