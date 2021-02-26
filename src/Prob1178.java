import java.lang.reflect.Array;
import java.util.*;

public class Prob1178 {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (String word : words) {
            int mask = 0;
            for (char ch : word.toCharArray()) {
                mask |= (1 << (ch-'a'));
            }
            count.put(mask, count.getOrDefault(mask, 0)+1);
        }
        int[] res = new int[puzzles.length];
        for (int i = 0; i < puzzles.length; i++) {
            int k = 0;
            for (char ch : puzzles[i].toCharArray()) {
                k |= (1 << (ch - 'a'));
            }

            int sub = k;
            do {
                sub = (sub - 1) & k;
                if (((1 << (puzzles[i].charAt(0) -'a')) & sub) != 0) {
                    res[i] += count.getOrDefault(sub, 0);
                }
            } while (sub != k);
        }
        List<Integer> r = new LinkedList<>();
        for (int a : res)
            r.add(a);
        return r;
    }
}
