import java.util.ArrayList;
import java.util.List;

public class Prob448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int next;
        int tmp;
        for (int i = 0;i < nums.length; i++) {
            if (nums[i] != 0) {
                tmp = nums[i] - 1;
                while (nums[tmp] != 0) {
                    next = nums[tmp] - 1;
                    nums[tmp] = 0;
                    tmp = next;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                res.add(i+1);
        }
        return res;
    }
}
