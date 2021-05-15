import java.util.HashSet;

public class Prob36 {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] blocks = new HashSet[27];
        for (int i = 0; i < 27; i++) {
            blocks[i] = new HashSet<Character>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ('0' <= board[i][j] && board[i][j] <='9') {
                    if (blocks[i].contains(board[i][j])) {
                        return false;
                    } else {
                        blocks[i].add(board[i][j]);
                    }
                    if (blocks[j + 9].contains(board[i][j])) {
                        return false;
                    } else {
                        blocks[j + 9].add(board[i][j]);
                    }
                    if (blocks[(i/3)*3+j/3+18].contains(board[i][j])) {
                        return false;
                    } else {
                        blocks[(i/3)*3+j/3+18].add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }
}
