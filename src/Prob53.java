public class Prob53 {
    public int maxSubArray(int[] nums) {
        // f[i]代表以第i个数字结尾的最大子序列和
        if (nums.length == 1)
            return nums[0];
        int[] f = new int[nums.length];
        f[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            f[i] = Math.max(nums[i], f[i-1]+nums[i]);
            res = Math.max(res, f[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Prob53 prob53 = new Prob53();
        System.out.println(prob53.maxSubArray(new int[]{1,2}));
    }
}
