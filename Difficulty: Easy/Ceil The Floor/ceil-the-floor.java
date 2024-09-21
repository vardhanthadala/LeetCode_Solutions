//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            Solution ob = new Solution();
            int[] ans = ob.getFloorAndCeil(x, arr);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
       int ceil=-1; //if ceil of x not found
       int floor=-1;//if floor of x not found
       int n=arr.length;
       
       int low=0;
       int high=n-1;
       
       // Sort the array first
        Arrays.sort(arr);
       
       while(low<=high){
           int mid=(low+high)/2;
           
           if(arr[mid]==x){
               return new int[]{x,x}; //if x found in arr then both floor and ceil is x
               
           }
           if(arr[mid]<x){
               floor=arr[mid];//floor found
               low=mid+1;//search remaining portion
           }else{
               ceil=arr[mid];//ceil found
               high=mid-1;//search remaining portion
           }
       }
       return new int[]{floor,ceil};
    }
}
