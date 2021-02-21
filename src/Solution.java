public class Solution {
    public int JumpFloor(int target) {
        int[] dp = new int[target];
        for(int i = 0;i < target; i++) {
            if (i == 0) {
                dp[i] = 1;
            } else if (i == 1) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i-2] + dp[i-1];
            }
        }
        return dp[target-1];
    }
}
