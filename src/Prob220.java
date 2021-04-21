import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Prob220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Long, Integer> map = new HashMap<>();
        TreeSet<Long> set = new TreeSet<>();
        int n = nums.length;
        if (n <= k) {
            for (int i = 0; i < n; i++) {
                if (set.ceiling((long) nums[i]) != null && Math.abs(set.ceiling((long) nums[i])-(long)nums[i]) <= t || set.floor((long) nums[i]) != null && Math.abs(set.floor((long) nums[i])-(long)nums[i]) <= t) {
                    return true;
                }
                set.add((long) nums[i]);
            }
            return false;
        }
        for (int i = 0; i <= k; i++) {
            if (set.ceiling((long) nums[i]) != null && Math.abs(set.ceiling((long) nums[i])-nums[i]) <= t || set.floor((long) nums[i]) != null && Math.abs(set.floor((long) nums[i])-nums[i]) <= t) {
                return true;
            }
            set.add((long) nums[i]);
            map.put((long) nums[i], map.getOrDefault((long)nums[i], 0) +1);
        }
        int cnt;
        for (int i = k + 1; i < n; i++) {
            cnt = map.get((long)nums[i-k-1]);
            if (cnt == 1) {
                map.remove((long)nums[i-k-1]);
                set.remove((long)nums[i-k-1]);
            } else {
                map.put((long) nums[i-k-1], cnt-1);
            }
            if (set.ceiling((long) nums[i]) != null && Math.abs(set.ceiling((long) nums[i])-(long)nums[i]) <= t || set.floor((long) nums[i]) != null && Math.abs(set.floor((long) nums[i])-(long)nums[i]) <= t) {
                return true;
            }
            set.add((long) nums[i]);
            map.put((long) nums[i], map.getOrDefault((long)nums[i], 0) +1);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Prob220().containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3,0));
    }
}
