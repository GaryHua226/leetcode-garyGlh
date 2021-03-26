public class Prob33 {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        int minIndex = findMinIndex(nums);
        System.out.println(minIndex);
        // 然后开始二分查找
        int left = 0;
        int right = n - 1;
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (nums[(minIndex + mid)%n] == target) {
                return (minIndex + mid) % n;
            }
            if (nums[(minIndex + mid) % n] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[(minIndex+left)%n] == target) {
            return (minIndex+left)%n;
        } else if (nums[(minIndex+right)%n] == target) {
            return (minIndex + right) % n;
        }
        return -1;
    }

    public static int findMinIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1}, 0));
    }
}
