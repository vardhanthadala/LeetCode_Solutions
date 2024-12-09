//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution { //T : O(2N) S:O(1)
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        int n = mat.length; 
        int top = 0;
        int down = n - 1;

        
        while (top < down) {
            if (mat[top][down] == 1) {
                // If 'top' knows 'down', then 'top' cannot be a celebrity
                top++;
            } else {
                // If 'down' knows 'top', then 'down' cannot be a celebrity
                down--;
            }
        }



        // Verify if the candidate is a real celebrity
        for (int i = 0; i < n; i++) {
            if (i != top) {//// Skip the candidate themselves
                // A celebrity must be known by everyone (mat[i][top] == 1)
                // A celebrity must not know anyone (mat[top][i] == 0)
                if (mat[i][top] == 0 || mat[top][i] == 1) {
                    return -1; // No celebrity exists
                }
            }
        }

        // If the top passes both checks, they are the celebrity
        return top;
    }
}
