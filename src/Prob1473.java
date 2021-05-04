import java.util.Arrays;

public class Prob1473 {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        // dp[i][j][k]: 前i个房子组成j个街区，且第i个房子的颜色为k，此时的最小花费

        int[][][] dp = new int[m][target+1][n+1];
        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, 0x3f3f3f3f);
            }
        }

        if (houses[0] == 0) {
            for (int k = 1; k <= n; k++) {
                dp[0][1][k] = cost[0][k-1];
            }
        } else {
            dp[0][1][houses[0]] = 0;
        }
// 转移
        for(int i = 1; i < m; i++) {
            // 房子本身无颜色
            if(houses[i] == 0) {
                for(int cur_color = 1; cur_color <= n; cur_color++) {
                    for(int prv_color = 1; prv_color <= n; prv_color++) {
                        for(int j = 1; j <= target; j++) {
                            if(cur_color == prv_color)
                                dp[i][j][cur_color] = Math.min(dp[i][j][cur_color], dp[i-1][j][cur_color] + cost[i][cur_color-1]);
                            else
                                dp[i][j][cur_color] = Math.min(dp[i][j][cur_color], dp[i-1][j-1][prv_color] + cost[i][cur_color-1]);
                        }
                    }
                }
            }
            // 房子本身有颜色
            else {
                int cur_color = houses[i];
                for(int prv_color = 1; prv_color <= n; prv_color++) {
                    for(int j = 1; j <= target; j++) {
                        if(cur_color == prv_color)
                            dp[i][j][cur_color] = Math.min(dp[i][j][cur_color], dp[i-1][j][cur_color]);
                        else
                            dp[i][j][cur_color] = Math.min(dp[i][j][cur_color], dp[i-1][j-1][prv_color]);
                    }
                }
            }
        }
        int ans = 0x3f3f3f3f;
        for (int num : dp[m-1][target]) {
            if (num < ans) {
                ans = num;
            }
        }
        return ans == 0x3f3f3f3f ? -1 : ans;
    }
}
