//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            boolean flag = ob.armstrongNumber(n);
            if (flag) {
                System.out.println("true");

            } else {
                System.out.println("false");
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static boolean armstrongNumber(int n) {
        // code here
        int originalNum=n;
        int sum=0;
        int digits=0;
        
        //coun the digits;
        int temp=n;
        while(temp!=0){
            digits++;
            temp/=10;
        }
        
        //now calculate for armstring numbers
        temp=n;
        while(temp>0){
            int lastDigit=temp%10;
            sum+=Math.pow(lastDigit,digits);
            temp/=10;
        }
        return (sum==originalNum);
    }
}