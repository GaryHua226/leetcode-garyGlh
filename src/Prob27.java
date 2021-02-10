public class Prob27 {
    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] == val)
                j++;
            nums[i] = nums[j];
            i++;
        }
        return i;
    }
}
