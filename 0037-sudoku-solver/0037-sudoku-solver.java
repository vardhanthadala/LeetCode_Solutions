class Solution {//time : O(9^(n^2))  space: O(1)
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) { //traversing rows
            for (int j = 0; j < 9; j++) {//traversing cols
                if (board[i][j] == '.') {//if board is empty
                    for (char c = '1'; c <= '9'; c++) {//fil it with  1-9 
                        if (isValid(board, i, j, c)) {//if it is valid place for an element to place then place it in the cell
                            board[i][j] = c;
                            if (solve(board)) {//recursively it try with other elements to place
                                return true;
                            } else {//if the element place is not valid then remove that element
                                board[i][j] = '.';
                            }
                        }

                    }
                    return false;
                }
            }

        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) {//if element already present in the col then return false
                return false;
            }
            if (board[row][i] == c) {//if element already present in the row then return false
                return false;
            }
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c){//for sub Matrix (3*3 Matrix) if the element is already present in the cell return false
                return false;
            }
        }
        return true;
    }
}