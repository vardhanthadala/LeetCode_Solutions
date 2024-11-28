class Solution {
    public boolean isBipartite(int[][] graph) {  //dfs
        int n = graph.length;
        int[] colors = new int[n]; // Array to store colors of nodes: 0 (uncolored), 1, or -1

        // Check each connected component
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0) { // If the node is not yet colored
                if (!canColor(graph, colors, i, 1)) {
                    return false; // If coloring fails, the graph is not bipartite
                }
            }
        }
        return true; // All components can be colored, graph is bipartite
    }

    private boolean canColor(int[][] graph, int[] colors, int node, int color) {
        // If already colored, check for consistency
        if (colors[node] == color) {
            return true; // Node is already correctly colored
        }
        if (colors[node] != 0) {
            return false; // Node is colored with the wrong color
        }

        // Color the current node
        colors[node] = color;

        // Attempt to color all adjacent nodes
        for (int neighbor : graph[node]) {
            if (!canColor(graph, colors, neighbor, -color)) {
                return false; // Return false if any neighbor cannot be colored
            }
        }

        return true; // Successfully colored all neighbors
    }
}
