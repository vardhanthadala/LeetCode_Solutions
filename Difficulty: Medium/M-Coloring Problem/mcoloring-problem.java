//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());      // Number of vertices
            String[] arrInput = br.readLine().trim().split(" "); // Input for edges

            List<int[]> edges = new ArrayList<>();
            for (int i = 0; i < arrInput.length; i += 2) {
                int u = Integer.parseInt(arrInput[i]);
                int v = Integer.parseInt(arrInput[i + 1]);
                edges.add(new int[] {u, v});
            }

            int m = Integer.parseInt(br.readLine().trim()); // Number of colors

            Solution sol = new Solution();
            System.out.println(sol.graphColoring(n, edges, m) ? "true" : "false");
        }
    }
}

// } Driver Code Ends


class Solution {
    
    private static boolean isSafe(int node,List<Integer>[]edges,int []color,int v,int col){
        for(int it:edges[node]){
            if(color[it]==col){
                return false;
            }
        }
        return true;
    }
    private static boolean solve(int node,List<Integer>edges[],int []color,int v,int m){
        
        if(node==v) return true;
        
        for(int i=1;i<=m;i++){
            if(isSafe(node,edges,color,v,i)){
               color[node]=i;
               if(solve(node+1,edges,color,v,m)==true){
                   return true;
               }
               color[node]=0;
            }
        }
        return false;
        
    }
    boolean graphColoring(int v, List<int[]> edges, int m) {
        List<Integer>[] adjList = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new ArrayList<>();
        }

        // Fill the adjacency list based on the given edges
        for (int[] edge : edges) {
            int u = edge[0], v1 = edge[1];
            adjList[u].add(v1);
            adjList[v1].add(u);  // Since the graph is undirected
        }

        // Initialize the color array with 0 (uncolored)
        int[] color = new int[v];

        // Start solving from the 0th node
        return solve(0, adjList, color, v, m);
    }
    
}