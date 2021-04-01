public class Prob1006 {
    public int clumsy(int N) {
        if (N == 1) {
            // 1
            return 1;
        } else if (N == 2) {
            // 2 x 1
            return 2;
        } else if (N == 3) {
            // 3 x 2 / 1
            return 6;
        }
        int res = N * (N - 1) / (N - 2);
        int tmp;
        for (int i = N - 3; i >= 1; i--) {
            res += i;
            i--;
            if (i == 0) {
                break;
            }
            tmp = i;
            i--;
            if (i == 0) {
                res -= tmp;
                break;
            }
            tmp *= i;
            i--;
            if (i == 0) {
                res -= tmp;
                break;
            }
            tmp /= i;
            res -= tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Prob1006().clumsy(4));
    }
}
