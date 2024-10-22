class Solution {
    private static List<String> construct(char board[][]) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String str = new String(board[i]);// converting each row of the board into string and adding it to result list
            res.add(str);
        }
        return res;
    }

    private static void solve(int col, char[][] board, int n, List<List<String>> ans, int leftRow[],
            int lowerDiagonal[], int upperDiagonal[]) {
        if (col == n)// Base case: if we place queens in all columns then add solution to the list
        {
            ans.add(construct(board));
            return;
        }
        for (int row = 0; row < n; row++) {
            //checking if placing a queen(row,col) is valid or not 
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[(n - 1) + row - col] == 0)
            {
                // Then mark the position with 1 as taken
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[(n - 1) + row - col] = 1;

                board[row][col] = 'Q';// place the queen at(row,col)
                solve(col + 1, board, n, ans, leftRow, lowerDiagonal, upperDiagonal);// recursivelyy place the queens at
                                                                                     // next cols

                // Backtracking --> removing the queens and unmark the position to try other
                // possibilities
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[(n - 1) + row - col] = 0;
                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        // Creating the chessboard as an n x n grid filled with '.'
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        // ans list to store all the possible solutions
        List<List<String>> ans = new ArrayList<>();

        // Arrays to keep track of which rows, and diagonals are under attack
        int leftRow[] = new int[n];
        int lowerDiagonal[] = new int[2 * n - 1];
        int upperDiagonal[] = new int[2 * n - 1];

        solve(0, board, n, ans, leftRow, lowerDiagonal, upperDiagonal);

        return ans;
    }
}