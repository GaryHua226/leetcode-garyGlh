import java.util.Arrays;

public class Prob647 {
    public int countSubstrings(String s) {
        int res = s.length();
        int length = s.length();
        boolean[][] f = new boolean[length][length];
        for (boolean[] t : f)
            Arrays.fill(t, true);
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                f[i][j] = s.charAt(i)==s.charAt(j) && f[i+1][j-1];
                if (f[i][j])
                    res++;
            }
        }
        return res;
    }


}
