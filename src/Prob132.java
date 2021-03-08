import java.util.Arrays;

public class Prob132 {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] g = new boolean[n][n];
        for (boolean[] t : g) {
            Arrays.fill(t, true);
        }
        for (int i = n-1; i >= 0; i--) {
            for(int j = i + 1; j < n; j++) {
                g[i][j] = g[i+1][j-1] && (s.charAt(i) == s.charAt(j));
            }
        }
        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if (g[0][i]) {
                f[i] = 0;
            }
            for (int j = 0; j < i; j++) {
                if (g[j+1][i]) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        return f[n-1];
    }
}
