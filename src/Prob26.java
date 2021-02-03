public class Prob26 {
    public int removeDuplicates(int[] nums) {
        int count = 0, index = 0;
        for (; index < nums.length; index++) {
            if (index == count)
                index++;
            if (nums[index] == nums[count]) {
                continue;
            }
            count++;
            nums[count] = nums[index];
        }
        return count;
    }
}
