class Solution {
    //DFS
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // Directions for traversal (top, right, bottom, left)
        int[] delrow = { -1, 0, +1, 0 };
        int[] delcol = { 0, +1, 0, -1 };

        // Step 1: Traverse the boundaries and eliminate connected land
        for (int i = 0; i < n; i++) {
            // First column
            if (grid[i][0] == 1) {
                dfs(i, 0, grid, delrow, delcol);
            }
            // Last column
            if (grid[i][m - 1] == 1) {
                dfs(i, m - 1, grid, delrow, delcol);
            }
        }
        for (int j = 0; j < m; j++) {
            // First row
            if (grid[0][j] == 1) {
                dfs(0, j, grid, delrow, delcol);
            }
            // Last row
            if (grid[n - 1][j] == 1) {
                dfs(n - 1, j, grid, delrow, delcol);
            }
        }

        // Step 2: Count remaining land cells
        int enclaveCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    enclaveCount++;
                }
            }
        }

        return enclaveCount;
    }

    private void dfs(int row, int col, int[][] grid, int[] delrow, int[] delcol) {
        grid[row][col] = 0; // Mark as visited by converting to water
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < 4; i++) {
            int newRow = row + delrow[i];
            int newCol = col + delcol[i];

            // Check bounds and if the neighbor is land
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1) {
                dfs(newRow, newCol, grid, delrow, delcol);
            }
        }
    }
}
