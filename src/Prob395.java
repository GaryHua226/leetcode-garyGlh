import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Prob395 {
    public int longestSubstring(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();
        HashMap<Character, List<Integer>> loc = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            count.put(ch, count.getOrDefault(ch, 0) + 1);
            if (!loc.containsKey(ch)) {
                loc.put(ch, new ArrayList<>());
            }
            loc.get(ch).add(i);
        }

        List<Integer> bad = new ArrayList<>();
        for (char ch : count.keySet()) {
            if (count.get(ch) < k) {
                bad.addAll(loc.get(ch));
            }
        }

        if (bad.size() == 0) {
            return s.length();
        }

        Integer[] indexs = bad.toArray(new Integer[0]);
        Arrays.sort(indexs);
        int res = 0;
        res = Math.max(longestSubstring(s.substring(0, indexs[0]),k),res);
        for (int i = 1; i < indexs.length; i++) {
            res = Math.max(longestSubstring(s.substring(indexs[i-1]+1,indexs[i]),k), res);
        }
        res = Math.max(longestSubstring(s.substring(indexs[indexs.length-1]+1),k),res);
        return res;
    }

    public static void main(String[] args) {
        Prob395 prob395 = new Prob395();
        System.out.println(prob395.longestSubstring("ababbc", 2));
    }
}
