//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.postToPre(s);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String postToPre(String str) {
        Stack<String> stack = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            char c= str.charAt(i);
            if(c=='^'||c=='*'||c=='/'||c=='+'||c=='-') {
                String t1 = stack.pop();
                String t2 = stack.pop();
                String temp = c+t2+t1;
                stack.push(temp);
            }else stack.push(Character.toString(c));
        }
        return stack.pop();
    }
}
