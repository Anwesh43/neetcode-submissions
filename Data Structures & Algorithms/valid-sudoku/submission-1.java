class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] squares = new boolean[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (!(board[i][j] >= '1' && board[i][j] <= '9')) {
                    continue;
                }
                int a = i / 3, b = j / 3;
                int r = 3 * a + b, c = 3 * (i % 3) + (j % 3);
                System.out.println(i + ", " + j +" --- " + r +", " + c);
                int index = board[i][j] - '1';
                if (rows[i][index]) {
                    return false;
                }
                if (cols[j][index]) {
                    return false;
                }
                if (squares[r][index]) {
                    return false;
                }
                rows[i][index] = true;
                cols[j][index] = true;
                squares[r][index] = true;
            }
        }
        return true;
    }
}


