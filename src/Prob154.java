public class Prob154 {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int m;
        if (l == r) {
            return nums[l];
        }
        while (l < r - 1) {
            if (nums[l] < nums[r]) {
                return nums[l];
            }
            m = (l + r) / 2;
            if (nums[l] == nums[r]) {
                if (nums[l] == nums[m]) {
                    l++;
                    r--;
                } else if (nums[m] > nums[l]) {
                    l = m;
                } else {
                    r = m;
                }
            } else {
                if (nums[m] >= nums[l]) {
                    l = m;
                } else {
                    r = m;
                }
            }
        }
        return Math.min(nums[l], nums[r]);
    }

    public static void main(String[] args) {
        System.out.println(new Prob154().findMin(new int[]{10,1,10,10,10}));
    }
}
