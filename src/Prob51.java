import java.util.ArrayList;
import java.util.List;

public class Prob51 {
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        boolean[] col = new boolean[n];
        boolean[] posDiag = new boolean[2*n-1];
        boolean[] negDiag = new boolean[2*n-1];
        List<String> lst = new ArrayList<>();
        dfs(n, 0, lst, col, posDiag, negDiag);
        return res;
    }

    public void dfs(int n, int currRow, List<String> currLst , boolean[] col, boolean[] posDiag, boolean[] negDiag) {
        if (currRow == n) {
            List<String> ans = new ArrayList<>(currLst);
            res.add(ans);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !posDiag[currRow + i] && !negDiag[currRow - i + n - 1]) {
                col[i] = true;
                posDiag[currRow+i] = true;
                negDiag[currRow-i+n-1] = true;
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < i - 1; j++) {
                    sb.append(".");
                }
                sb.append("Q");
                for (int j = i + 1; j < n; j++) {
                    sb.append(".");
                }
                currLst.add(sb.toString());
                dfs(n, currRow+1, currLst, col, posDiag, negDiag);
                currLst.remove(currLst.size()-1);
            }
        }
    }
}
