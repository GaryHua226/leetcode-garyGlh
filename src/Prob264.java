import java.util.TreeSet;

public class Prob264 {
    public int nthUglyNumber(int n) {
        if (n <= 6) {
            return n;
        }
        TreeSet<Integer> uglyNumbers = new TreeSet<>();
        for (int i = 1; i <= 6; i++) {
            uglyNumbers.add(i);
        }
        int cur = 1;
        while (cur < n) {
            int tmp = uglyNumbers.first();
            uglyNumbers.remove(tmp);
            if (tmp * 2 > 0)
                uglyNumbers.add(tmp * 2);
            if (tmp * 3 > 0)
                uglyNumbers.add(tmp * 3);
            if (tmp * 5 > 0)
                uglyNumbers.add(tmp * 5);
            cur++;
        }
        return uglyNumbers.first();
    }

    public static void main(String[] args) {
        int res = new Prob264().nthUglyNumber(10);
        System.out.println(res);
    }
}
