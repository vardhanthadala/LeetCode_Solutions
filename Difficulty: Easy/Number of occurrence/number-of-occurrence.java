//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.countFreq(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        int first=findFirst(arr,target);
        int last=findLast(arr,target);
        
          if (first == -1 || last == -1) {
            return 0;
        }
        
    return last-first+1;
    }
     
     
    public static int findFirst(int arr[],int target){
        int n=arr.length;
        int left=0;
        int right=n-1;
        int result=-1;

        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]==target){
                result=mid;
                right=mid-1;
            }else if(arr[mid]<target){
             left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return result;

    }

    public static int findLast(int arr[],int target){
        int n=arr.length;
        int left=0;
        int right=n-1;
        int result=-1;

        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]==target){
                result=mid;
                left=mid+1;
            }else if(arr[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return result;
    }
}