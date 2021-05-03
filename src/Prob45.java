import java.util.Arrays;

public class Prob45 {
    public int jump(int[] nums) {
        int[] record = new int[nums.length];
        Arrays.fill(record, Integer.MAX_VALUE);
        for (int i = 0; i < nums.length; i++) {
            int cur = record[0];
            for (int j = 1; j <= nums[i] && i+j < nums.length; j++) {
                record[i+j] = Math.min(cur+1, record[i+j]);
            }
        }
        return record[nums.length-1];
    }
}
