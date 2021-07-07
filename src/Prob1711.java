import java.util.HashMap;
import java.util.Map;

public class Prob1711 {
    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> mp = new HashMap<>();
        long cnt = 0;
        for (int i : deliciousness) {
            for (int j = 1; j < (1 << 30); j <<= 1) {
                if (j > i) {
                    cnt += mp.getOrDefault(j - i, 0);
                    cnt %= 1000000007;
                }
            }
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        return (int)cnt;
    }

}
