public class Solution {
    // Grid approach

    public int numIslands(char[][] grid) {

        int count = 0;
        // traverse the grid elements one by one
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // increment the count and do DFS for the adjacent cells
                if (grid[i][j] == '1') {
                    count++;
                    DFS(grid, i, j);
                }
            }
        }

        return count;
    }

    private void DFS(char[][] grid, int i, int j) {
        // the base cases where the DFS traversal should stop
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        // mark the element as 0 or visited so that it won't be taken into account, when
        // visited again.
        grid[i][j] = '0'; // Mark as visited

        // DFS for up element
        DFS(grid, i - 1, j);
        // DFS for down element
        DFS(grid, i + 1, j);
        // DFS for left element
        DFS(grid, i, j - 1);
        // DFS for right element
        DFS(grid, i, j + 1);
    }

    // Graph approach

    // public void dfs(int i, int j, char[][] grid) {
    //     if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1')
    //         return;

    //     // mark visited
    //     grid[i][j] = '0';

    //     dfs(i + 1, j, grid);
    //     dfs(i - 1, j, grid);
    //     dfs(i, j + 1, grid);
    //     dfs(i, j - 1, grid);
    // }

    // public int numIslands(char[][] grid) {

    //     int cnt = 0;

    //     for (int i = 0; i < grid.length; i++) {
    //         for (int j = 0; j < grid[0].length; j++) {
    //             if (grid[i][j] == '1') {
    //                 dfs(i, j, grid);
    //                 cnt++;
    //             }
    //         }
    //     }
    //     return cnt;
    // }

}