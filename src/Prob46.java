import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prob46 {
    private List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        boolean[] a = new boolean[nums.length];
        permute(nums, new ArrayList<>(), a);
        return res;
    }

    public void permute(int[] nums, List<Integer> cur,  boolean[] a) {
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            if (a[i] = false) {
                flag = false;
                cur.add(nums[i]);
                a[i] = true;
                permute(nums, cur, a);
                cur.remove(cur.size()-1);
                a[i] = false;
            }
        }
        if (flag) {
            ArrayList<Integer> newResult = new ArrayList<>(cur);
            res.add(newResult);
        }
    }
}
