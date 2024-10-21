//{ Driver Code Starts

// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                arr.add(sc.nextInt());
            }
            Solution ob = new Solution();

            ArrayList<Integer> ans = ob.subsetSums(arr, N);
            Collections.sort(ans);
            for (int sum : ans) {
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java//User function Template for Java
class Solution {
    
    private void func(int idx,int sum ,ArrayList<Integer>arr,int n,ArrayList<Integer>sumSubset){
        
        if(n==idx){    // if u reached n then that sum will be a sum of subset
            sumSubset.add(sum);
            return;
        }
        
        //pick element from array
        func( idx+1, sum+arr.get(idx) ,arr, n,sumSubset);
        //Dont pick element from array
        func( idx+1, sum ,arr, n,sumSubset);
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        // code here
        ArrayList<Integer>sumSubset=new ArrayList<>();
        func( 0, 0 ,arr, n,sumSubset);
        Collections.sort(sumSubset);
        
        return sumSubset;

    }
}