package DP;

import java.util.Arrays;

public class Prob08_01 {
    public int waysToStep(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (n == 3)
            return 4;
        long[] f = new long[n];
        f[0] = 1;
        f[1] = 2;
        f[2] = 4;
        for (int i = 3; i < n; i++) {
            f[i] = f[i-3] + f[i-2] + f[i-1];
        }
        return (int) f[n-1] % 1000000007;
    }
}
