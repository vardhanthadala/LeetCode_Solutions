class Solution {
    //DFS
    // public int numEnclaves(int[][] grid) {
    //     int n = grid.length;
    //     int m = grid[0].length;

    //     // Directions for traversal (top, right, bottom, left)
    //     int[] delrow = { -1, 0, +1, 0 };
    //     int[] delcol = { 0, +1, 0, -1 };

    //     // Step 1: Traverse the boundaries and eliminate connected land
    //     for (int i = 0; i < n; i++) {
    //         // First column
    //         if (grid[i][0] == 1) {
    //             dfs(i, 0, grid, delrow, delcol);
    //         }
    //         // Last column
    //         if (grid[i][m - 1] == 1) {
    //             dfs(i, m - 1, grid, delrow, delcol);
    //         }
    //     }
    //     for (int j = 0; j < m; j++) {
    //         // First row
    //         if (grid[0][j] == 1) {
    //             dfs(0, j, grid, delrow, delcol);
    //         }
    //         // Last row
    //         if (grid[n - 1][j] == 1) {
    //             dfs(n - 1, j, grid, delrow, delcol);
    //         }
    //     }

    //     // Step 2: Count remaining land cells
    //     int enclaveCount = 0;
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < m; j++) {
    //             if (grid[i][j] == 1) {
    //                 enclaveCount++;
    //             }
    //         }
    //     }

    //     return enclaveCount;
    // }

    // private void dfs(int row, int col, int[][] grid, int[] delrow, int[] delcol) {
    //     grid[row][col] = 0; // Mark as visited by converting to water
    //     int n = grid.length;
    //     int m = grid[0].length;

    //     for (int i = 0; i < 4; i++) {
    //         int newRow = row + delrow[i];
    //         int newCol = col + delcol[i];

    //         // Check bounds and if the neighbor is land
    //         if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1) {
    //             dfs(newRow, newCol, grid, delrow, delcol);
    //         }
    //     }
    // }
   

   //BFS
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // Directions for traversal (top, right, bottom, left)
        int[] delrow = { -1, 0, +1, 0 };
        int[] delcol = { 0, +1, 0, -1 };

        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Add all boundary land cells to the queue and mark them as water
        for (int i = 0; i < n; i++) {
            // First column
            if (grid[i][0] == 1) {
                queue.offer(new int[] { i, 0 });
                grid[i][0] = 0;
            }
            // Last column
            if (grid[i][m - 1] == 1) {
                queue.offer(new int[] { i, m - 1 });
                grid[i][m - 1] = 0;
            }
        }
        for (int j = 0; j < m; j++) {
            // First row
            if (grid[0][j] == 1) {
                queue.offer(new int[] { 0, j });
                grid[0][j] = 0;
            }
            // Last row
            if (grid[n - 1][j] == 1) {
                queue.offer(new int[] { n - 1, j });
                grid[n - 1][j] = 0;
            }
        }

        // Step 2: Process the queue to eliminate all boundary-connected land
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for (int i = 0; i < 4; i++) {
                int newRow = row + delrow[i];
                int newCol = col + delcol[i];

                // Check bounds and if the neighbor is land
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1) {
                    queue.offer(new int[] { newRow, newCol });
                    grid[newRow][newCol] = 0; // Mark as water
                }
            }
        }

        // Step 3: Count remaining land cells
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
}