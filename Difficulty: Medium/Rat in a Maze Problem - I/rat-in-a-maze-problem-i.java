//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends



class Solution {

    public static void solveMaze(ArrayList<String> ans, int r, int c, int[][] m, int n, String p, boolean[][] vis) {
        if (r == n-1  && c == n-1  && m[r][c] != 0) {
            ans.add(p); 
            return;
        }

        // Check for bounds and if the current cell is visited or blocked
        if (r >= 0 && r < n && c >= 0 && c < n) {
            if (vis[r][c] || m[r][c] == 0) {
                return;
            }

            // Mark the cell as visited
            vis[r][c] = true;

            // Explore the three possible valid directions (excluding the direction we came from)
            if (r + 1 < n && !vis[r + 1][c])  // Move down
                solveMaze(ans, r + 1, c, m, n, p + 'D', vis);
            if (c - 1 >= 0 && !vis[r][c - 1])  // Move left
                solveMaze(ans, r, c - 1, m, n, p + 'L', vis);
            if (c + 1 < n && !vis[r][c + 1])  // Move right
                solveMaze(ans, r, c + 1, m, n, p + 'R', vis);
            if (r - 1 >= 0 && !vis[r - 1][c])  // Move up
                solveMaze(ans, r - 1, c, m, n, p + 'U', vis);

            // Backtrackng: unmark the cell as visited
            vis[r][c] = false;
        }
    }

    public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> ans = new ArrayList<>();
        int n = mat.length;  
        boolean[][] vis = new boolean[n][n];  // Visited array

        solveMaze(ans, 0, 0, mat, n, "", vis);

        return ans; 
    }
}
