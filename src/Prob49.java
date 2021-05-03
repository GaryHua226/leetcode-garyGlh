import java.util.*;

public class Prob49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] tmp = s.toCharArray();
            Arrays.sort(tmp);
            String k = String.valueOf(tmp);
            if (!map.containsKey(k)) {
                map.put(k, new ArrayList<>());
            }
            map.get(k).add(s);
        }
        List<List<String>> res = new ArrayList<>();
        for (String k : map.keySet()) {
            res.add(map.get(k));
        }
        return res;
    }
}
