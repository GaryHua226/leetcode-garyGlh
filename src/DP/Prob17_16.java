package DP;

import java.util.Arrays;

public class Prob17_16 {
    public int massage(int[] nums) {
        if (nums.length == 0)
            return nums[0];
        int[][] f = new int[nums.length][2];
        for (int[] tmp : f) {
            Arrays.fill(tmp, 0);
        }
        f[0][0] = 0;
        f[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            f[i][0] = Math.max(f[i-1][0], f[i-1][1]);
            f[i][1] = f[i-1][0] + nums[i];
        }
        return Math.max(f[nums.length-1][0], f[nums.length-1][1]);
    }
}
