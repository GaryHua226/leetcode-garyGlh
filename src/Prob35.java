public class Prob35 {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int l = 0, r = nums.length - 1;
        if (nums[l] > target) {
            return 0;
        }
        if (nums[r] < target) {
            return r + 1;
        }
        while (l < r - 1) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if (nums[l] == target) {
            return l;
        }
        return r;
    }
}
