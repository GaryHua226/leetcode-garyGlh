package DP;

public class Prob16_17 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] f = new int[nums.length];
        f[0] = nums[0];
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            f[i] = nums[i];
            if (f[i-1] > 0)
                f[i] = f[i] + f[i-1];
            res = Math.max(res, f[i]);
        }
        return res;
    }
}
