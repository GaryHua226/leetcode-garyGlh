package DP;

import java.util.Arrays;

public class Offer42 {
    public int maxSubArray(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return Math.max(nums[0], 0);
        int[] f = new int[nums.length];
        f[0]= Math.max(nums[0], 0);
        int res = Math.max(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            f[i] = Math.max(f[i-1]+nums[i], nums[i]);
            res = Math.max(res, f[i]);
        }
        return res;
    }
}
