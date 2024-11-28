class Solution {
    // public boolean isBipartite(int[][] graph) { // dfs
    //     int n = graph.length;
    //     int[] colors = new int[n]; // Array to store colors of nodes: 0 (uncolored),1, or -1

    //     // Check each connected component
    //     for (int i = 0; i < n; i++) {
    //         if (colors[i] == 0) { // If the node is not yet colored
    //             if (!canColor(graph, colors, i, 1)) {
    //                 return false; // If coloring fails, the graph is not bipartite
    //             }
    //         }
    //     }
    //     return true; // All components can be colored, graph is bipartite
    // }

    // private boolean canColor(int[][] graph, int[] colors, int node, int color) {
    //     // If already colored, check for consistency
    //     if (colors[node] == color) {
    //         return true; // Node is already correctly colored
    //     }
    //     if (colors[node] != 0) {
    //         return false; // Node is colored with the wrong color
    //     }

    //     // Color the current node
    //     colors[node] = color;

    //     // Attempt to color all adjacent nodes
    //     for (int neighbor : graph[node]) {
    //         if (!canColor(graph, colors, neighbor, -color)) {
    //             return false; // Return false if any neighbor cannot be colored
    //         }
    //     }

    //     return true; // Successfully colored all neighbors
    // }

    public boolean isBipartite(int[][] graph) {// bfs
        int n = graph.length;  // Number of nodes in the graph
        int[] colors = new int[n];  // Array to track colors (0 = unvisited, 1 = red, -1 = blue)

        // Check all connected components
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0) {  // Unvisited node
                if (!bfsCheck(graph, colors, i)) {
                    return false;  // If any component is not bipartite, return false
                }
            }
        }
        return true;  // All components are bipartite
    }

    private boolean bfsCheck(int[][] graph, int[] colors, int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        colors[startNode] = 1;  // Start coloring the first node with color 1 (red)

        while (!queue.isEmpty()) {
            int node = queue.poll();  // Process the current node

            // Traverse all its neighbors
            for (int neighbor : graph[node]) {
                if (colors[neighbor] == 0) {  // If the neighbor is unvisited
                    colors[neighbor] = -colors[node];  // Assign the opposite color
                    queue.add(neighbor);  // Add the neighbor to the queue
                } else if (colors[neighbor] == colors[node]) {
                    // If the neighbor has the same color as the current node, the graph is not bipartite
                    return false;
                }
            }
        }
        return true;  // Successfully colored the graph
    }
}