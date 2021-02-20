import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Prob697 {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> record = new HashMap<>();
        int maxCount = 0;
        int tmp;
        int count;
        for (int i = 0; i < nums.length; i++) {
            tmp = nums[i];
            if (!record.containsKey(tmp)) {
                record.put(tmp, new ArrayList<>(Arrays.asList(0,i,0)));
            }
            count = record.get(tmp).get(0);
            if (count >= maxCount) {
                maxCount++;
            }
            record.get(tmp).set(0, count+1);
            record.get(tmp).set(2, i);
        }
        int res = nums.length;
        for (Integer key : record.keySet()) {
            if (record.get(key).get(0) == maxCount) {
                tmp = record.get(key).get(2)-record.get(key).get(1)+1;
                res = Math.min(tmp, res);
            }
        }
        return res;
    }
}
