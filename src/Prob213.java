public class Prob213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }  else if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[n - 1];
        // case 1
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < n- 1;i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        int res1 = Math.max(dp[n-2], dp[n-3]);

        dp[0] = nums[1];
        dp[1] = Math.max(dp[0],nums[2]);
        int i;
        for (int j = 3; j < n; j++) {
            i = j - 1;
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[j]);
        }
        int res2 = Math.max(dp[n-2], dp[n-3]);

        return Math.max(res1, res2);
    }

    public static void main(String[] args) {
        new Prob213().rob(new int[]{1,3,1,3,100});
    }
}
