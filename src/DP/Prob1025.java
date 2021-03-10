package DP;

import java.util.Arrays;

public class Prob1025 {
    public boolean divisorGame(int N) {
        if (N == 2)
            return true;
        if (N == 3)
            return false;
        boolean[] f = new boolean[N+1];
        Arrays.fill(f, false);
        f[2] = true;
        f[3] = false;
        for (int i = 4; i < N; i++) {
            for (int j = 1; j < Math.sqrt(N); j++) {
                if (i % j == 0 && !f[i - j]) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[N];
    }
}
