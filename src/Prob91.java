public class Prob91 {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        if (s.charAt(0) == '0') {
            return 0;
        }
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            boolean flag = false;
            if (s.charAt(i) != '0') {
                flag = true;
                dp[i] = dp[i-1];
            }
            int tmp = Integer.parseInt(s.substring(i-1, i+1));
            if (tmp >= 10 && tmp <= 26) {
                flag = true;
                if (i == 1) {
                    dp[i] += 1;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
            if (!flag) {
                return 0;
            }
        }
        return dp[s.length()-1];
    }

    public static void main(String[] args) {
        System.out.println(new Prob91().numDecodings("11106"));
    }
}
