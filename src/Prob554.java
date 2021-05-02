import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob554 {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> layer : wall) {
            int curLength = 0;
            for (int i = 0; i < layer.size() - 1; i++)  {
                curLength += layer.get(i);
                map.put(curLength, map.getOrDefault(curLength, 0) + 1);
            }
        }
        int n = wall.size();
        int res = n;
        for (Integer key : map.keySet()) {
            res = Math.min(res, n - map.get(key));
        }
        return res;
    }

    public static void main(String[] args) {
        new Prob554().leastBricks(null);
    }
}
