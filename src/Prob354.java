import java.util.Arrays;

public class Prob354 {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if (n == 0)
            return 0;
        Arrays.sort(envelopes, (a,b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
//        for (int[] a : envelopes)
//            System.out.println(a[0]+","+a[1]);
        int[] dp = new int[n];
        dp[0] = 1;
        int k;
        int res = 1;
        int tmp = 0;
        for (int i = 1; i < n; i++) {
            tmp = 0;
            for (int j = 0; j < i; j++) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    tmp = Math.max(tmp, dp[j]);
                }
            }
            dp[i] = tmp + 1;
            res = Math.max(res, dp[i]);
        }
//        System.out.println(dp[n-1]);
//        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        Prob354 prob354 = new Prob354();
        prob354.maxEnvelopes(new int[][]{{1,3},{3,5},{6,7},{6,8},{8,4},{9,5}});
    }
}
