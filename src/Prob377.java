import java.util.Arrays;

public class Prob377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        Arrays.sort(nums);
        for (int i = 0; i <= target; i++) {
            for (int num : nums) {
                if (i == num) {
                    dp[i] += 1;
                }
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                } else {
                    break;
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(new Prob377().combinationSum4(new int[]{1,2,3}, 4));
    }
}
