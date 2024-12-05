//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


class Solution {
    public static String infixToPostfix(String exp) {
    Stack<Character> st = new Stack<>();
    StringBuilder ans = new StringBuilder();  
    
    for (int i = 0; i < exp.length(); i++) {
        char ch = exp.charAt(i);  
        
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
            ans.append(ch);  
        } else if (ch == '(') {//if it is opening '( ' then push to stack
            st.push(ch);
        } else if (ch == ')') {////if it is opening ')' then keep pop out till u recheased to '('
            while (!st.isEmpty() && st.peek() != '(') {
                ans.append(st.pop());  
            }
            if (!st.isEmpty()) {
                st.pop(); // Pop '('
            }
        } else {
            // If an operator is scanned
            while (!st.isEmpty() && priority(ch) <= priority(st.peek())) {  // Corrected from st.top() to st.peek()
                ans.append(st.pop()); 
            }
            st.push(ch);
        }
    }
    
    // Pop all remaining operators from the stack
    while (!st.isEmpty()) {
        ans.append(st.pop());
    }
    
    return ans.toString();  
}

private static int priority(char ch) {
    if (ch == '^') {
        return 3;
    } else if (ch == '*' || ch == '/') {
        return 2;
    } else if (ch == '+' || ch == '-') {
        return 1;
    } else {
        return -1;
    }
}

}