class Solution {
    private static void dfs(int[][] graph, int curr, boolean[] visited) {
        visited[curr] = true;

        for (int i = 0; i < graph.length; i++) {
            // If there is a direct connection and the node has not been visited
            if (graph[curr][i] == 1 && !visited[i]) {
                //then visit it by recursively
                dfs(graph, i, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            //If not been visited, perform DFS from it
            if (!visited[i]) {
                dfs(isConnected, i, visited);
                cnt++;
            }
        }
        return cnt;
    }

}