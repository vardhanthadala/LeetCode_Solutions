//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {//using BFS time : O(V+E)  space : O(V)
      
        boolean[] visited = new boolean[adj.size()];
          for (int i = 0; i <adj.size(); i++) {
            if (!visited[i]) { // If node is unvisited, start a DFS
                if (dfs(i, -1, adj, visited)) {
                    return true; // Cycle detected
                }
            }
        }

        return false; // No cycle found
        
    }
    private boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        
        visited[node] = true; // Mark the current node as visited
        
        //Explore the neighbors
         for(int neighbor : adj.get(node)){
            if(!visited[neighbor]){
                if (dfs(neighbor, node, adj, visited)) {
                  return true; // Cycle detected 
               }
            }else if (neighbor != parent) {
            // If neighbor is visited and not the parent, cycle detected
            return true;
            }
        }
        return false;
    }
}