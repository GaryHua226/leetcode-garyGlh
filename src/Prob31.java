import java.util.Arrays;

public class Prob31 {
    public void nextPermutation(int[] nums) {
        // 当开始有递减的时候就是要替换的位置
        // 问题是和谁进行交换能够获得一个最小的数呢？
        int i = nums.length - 2;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                break;
            }
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j]= tmp;
        }
        // 从 i+1 到 nums.length-1 进行数组反转
        int k = i + 1;
        for (int c = 0; c < (nums.length - 1 - i) / 2; c++) {
            int tmp = nums[k+c];
            nums[k+c] = nums[nums.length-1-c];
            nums[nums.length-1-c] = tmp;
        }
    }
}
