import java.util.ArrayList;
import java.util.List;

public class Prob22 {
    ArrayList[] cache = new ArrayList[10];

    public List<String> generateParenthesis(int n) {
        if (cache[n] != null)
            return cache[n];
        ArrayList<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; c++) {
                for (String left : generateParenthesis(c)) {
                    for (String right : generateParenthesis(n - c - 1)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache[n] = ans;
        return ans;
    }
}
