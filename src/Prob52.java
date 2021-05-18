import java.util.ArrayList;
import java.util.List;

public class Prob52 {
    int res;

    public int solveNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] posDiag = new boolean[2*n-1];
        boolean[] negDiag = new boolean[2*n-1];
        dfs(n, 0, col, posDiag, negDiag);
        return res;
    }

    public void dfs(int n, int currRow, boolean[] col, boolean[] posDiag, boolean[] negDiag) {
        if (currRow == n) {
            res++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !posDiag[currRow + i] && !negDiag[currRow - i + n - 1]) {
                col[i] = true;
                posDiag[currRow+i] = true;
                negDiag[currRow-i+n-1] = true;
                dfs(n, currRow+1, col, posDiag, negDiag);
                col[i] = false;
                posDiag[currRow+i] = false;
                negDiag[currRow-i+n-1] = false;
            }
        }
    }
}
