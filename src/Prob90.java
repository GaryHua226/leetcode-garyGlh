import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Prob90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        int n = 1;
        for (int i : map.keySet()) {
            n *= (map.get(i)+1);
        }
        ArrayList<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>());
        }
        int m;
        int cur = n;
        for (int i : map.keySet()) {
            m = map.get(i);
            cur /= m;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < j / cur % (m + 1); k++) {
                    ans.get(j).add(i);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new Prob90().subsetsWithDup(new int[]{1,2,2});
    }
}
