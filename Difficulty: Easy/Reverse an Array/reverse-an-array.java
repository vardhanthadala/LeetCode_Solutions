//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String str[] = br.readLine().split(" ");
            int arr[] = new int[str.length];

            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            Solution obj = new Solution();

            obj.reverseArray(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public void reverseArray(int arr[]) {
        // code here
        reverseHelperFunc(arr,0);
    }
    private void reverseHelperFunc(int arr[],int i){
        
        int n = arr.length;
        
        if( i >= n/2){//stop recursion if it exceeds middle elemenet
            return;
        }
        int temp = arr[i];
        arr[i] = arr[n-1-i];
        arr[n-1-i] = temp;
        
         reverseHelperFunc(arr, i + 1);//recursive call for next index
    }
}