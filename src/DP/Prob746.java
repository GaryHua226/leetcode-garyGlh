package DP;

public class Prob746 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 1)
            return cost[0];
        if (n == 2)
            return Math.min(cost[0], cost[1]);
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = cost[0];
        f[2] = Math.min(cost[0], cost[1]);
        for (int i = 3; i < n + 1; i++) {
            f[i] = Math.min(f[i-2] + cost[i-2], f[i-1] + cost[i-1]);
        }
        return f[n];
    }
}
