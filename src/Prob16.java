import java.util.Arrays;

public class Prob16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        // 双指针
        int res = 0;
        int delta = Integer.MAX_VALUE;
        for (int i = 0;i < nums.length; i++) {
            // i指向第一个数字，后面用双指针来找距离target-nums[i]最小的
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int temp = Math.abs(nums[i]+nums[start]+nums[end]-target);
                if (temp < delta) {
                    if (temp == 0)
                        return target;
                    res = nums[i]+nums[start]+nums[end];
                    delta = Math.abs(nums[i]+nums[start]+nums[end]-target);
                }
                if (nums[i]+nums[start]+nums[end] > target) {
                    while (start < end && nums[end-1] == nums[end])
                        end--;
                    end--;
                } else {
                    while (start < end && nums[start+1] == nums[start])
                        start++;
                    start++;
                }
            }
        }
        return res;
    }
}
