public class Prob153 {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        if (nums[l] < nums[r]) {
            return nums[l];
        }
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] > nums[l]) {
                l = m;
            } else {
                r = m;
            }
        }
        return nums[l];
    }
}
