package DP;

public class Prob121 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int min = prices[0];
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }
}