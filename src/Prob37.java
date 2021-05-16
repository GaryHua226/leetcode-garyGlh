import com.sun.corba.se.spi.activation.BadServerDefinition;

import java.util.HashSet;

public class Prob37 {
    public void solveSudoku(char[][] board) {
        HashSet<Character>[] blocks = new HashSet[27];
        for (int i = 0; i < 27; i++) {
            blocks[i] = new HashSet<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                int idx1 = i;
                int idx2 = j + 9;
                int idx3 = (i / 3) * 3 + j / 3 + 18;
                blocks[idx1].add(board[i][j]);
                blocks[idx2].add(board[i][j]);
                blocks[idx3].add(board[i][j]);
            }
        }
        solveSudoku_r(board, 0, 0, blocks);
    }

    public boolean solveSudoku_r(char[][] board, int i, int j, HashSet<Character>[] blocks) {
        if (board[i][j] != '.') {
            if (j == 8) {
                if (i == 8) {
                    return true;
                } else {
                    return solveSudoku_r(board, i + 1, 0, blocks);
                }
            } else {
                return solveSudoku_r(board, i, j + 1, blocks);
            }
        }
        int idx1 = i;
        int idx2 = j + 9;
        int idx3 = (i / 3) * 3 + j / 3 + 18;
        boolean flag;
        for (int k = 1; k <= 9; k++) {
            char ch = String.valueOf(k).charAt(0);
            if (blocks[idx1].contains(ch) || blocks[idx2].contains(ch) || blocks[idx3].contains(ch)) {
                continue;
            }
            board[i][j] = ch;
            blocks[idx1].add(board[i][j]);
            blocks[idx2].add(board[i][j]);
            blocks[idx3].add(board[i][j]);
            if (j == 8) {
                if (i == 8) {
                    return true;
                } else {
                    flag = solveSudoku_r(board, i + 1, 0, blocks);
                }
            } else {
                flag = solveSudoku_r(board, i, j + 1, blocks);
            }
            if (flag) {
                return true;
            }
            blocks[idx1].remove(board[i][j]);
            blocks[idx2].remove(board[i][j]);
            blocks[idx3].remove(board[i][j]);
            board[i][j] = '.';
        }
        return false;
    }
}
