class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        // Directions for top, right, bottom, left
        int[] delrow = { -1, 0, +1, 0 };
        int[] delcol = { 0, 1, 0, -1 };

        int[][] vis = new int[n][m];

        // Traverse the first and last rows
        for (int j = 0; j < m; j++) {
            // First row
            if (board[0][j] == 'O' && vis[0][j] == 0) {
                dfs(0, j, vis, board, delrow, delcol);
            }
            // Last row
            if (board[n - 1][j] == 'O' && vis[n - 1][j] == 0) {
                dfs(n - 1, j, vis, board, delrow, delcol);
            }
        }

        // Traverse the first and last columns
        for (int i = 0; i < n; i++) {
            // First column
            if (board[i][0] == 'O' && vis[i][0] == 0) {
                dfs(i, 0, vis, board, delrow, delcol);
            }
            // Last column
            if (board[i][m - 1] == 'O' && vis[i][m - 1] == 0) {
                dfs(i, m - 1, vis, board, delrow, delcol);
            }
        }

        // Replace all unvisited 'O's with 'X'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && vis[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int row, int col, int[][] vis, char[][] board, int[] delrow, int[] delcol) {
        vis[row][col] = 1;

        int n = board.length;
        int m = board[0].length;

        // Explore all four neighbors
        for (int i = 0; i < 4; i++) {
            int newRow = row + delrow[i];
            int newCol = col + delcol[i];

            // Check if the neighbor is within bounds, unvisited, and an 'O'
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m
                    && vis[newRow][newCol] == 0 && board[newRow][newCol] == 'O') {
                dfs(newRow, newCol, vis, board, delrow, delcol);
            }
        }
    }
}
