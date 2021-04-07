public class Prob80 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int last = nums[0];
        int cnt = 1;
        int head = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] != last) {
                last = nums[i];
                cnt = 1;
                nums[head++] = nums[i];
            } else if (cnt == 1) {
                cnt = 2;
                nums[head++] = nums[i];
            } else {
                continue;
            }
        }
        return head;
    }
}
