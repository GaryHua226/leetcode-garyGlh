import java.util.HashSet;

public class Prob888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int[] res = new int[2];
        int a = 0, b = 0;
        for (int i : A)
            a += i;
        for (int i : B)
            b += i;
        HashSet<Integer> set = new HashSet<>();
        for (int i : A)
            set.add(i);
        int delta = a - b;
        for (int k : B) {
            if (set.contains(k + delta / 2)) {
                res[0] = k+delta/2;
                res[1] = k;
                return res;
            }
        }
        return res;
    }
}
